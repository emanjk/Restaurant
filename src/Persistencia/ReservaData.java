package Persistencia;

import Modelo.Mesa;
import Modelo.Reserva;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

public class ReservaData {
    private Connection con; 
    private MesaData mesaData;
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    // Constructor
    public ReservaData(Connection connection) {
        this.con = connection;
        this.mesaData = new MesaData(con);
        iniciarMonitorDeReservas();
    }

    private void iniciarMonitorDeReservas() {
        scheduler.scheduleAtFixedRate(this::verificarYActualizarReservas, 0, 1, TimeUnit.HOURS);
    }

    // 1.Método para verificar y actualizar reservas expiradas
    private void verificarYActualizarReservas() {
        List<Reserva> reservas = listarReservas();

        for (Reserva reserva : reservas) {
            LocalDateTime fechaHoraReserva = reserva.getFechaHora();
            LocalDateTime ahora = LocalDateTime.now();

            // Verifica si han pasado 2 horas desde la fecha de la reserva y está activa
            if (ChronoUnit.HOURS.between(fechaHoraReserva, ahora) >= 2 && reserva.isEstado()) {
                // Cambia el estado de la reserva y libera la mesa
                reserva.setEstado(false);
                modificarReserva(reserva);

                Mesa mesa = reserva.getMesa();
                mesa.setSituacion("Libre");
                mesa.setEstado(true); 
                mesaData.modificarMesa(mesa);

                System.out.println("Reserva ID " + reserva.getIdReserva() + " ha expirado y la mesa ha sido liberada.");
            }
        }
    }

    public void cerrarScheduler() {
        scheduler.shutdown();
    }

    // 2. Método para agregar una reserva y verificar disponibilidad
    public synchronized void agregarReserva(Reserva reserva) {
        if (!verificarDisponibilidad(reserva.getMesa().getIdMesa(), reserva.getFechaHora())) {
            JOptionPane.showMessageDialog(null, "La mesa no está disponible para el horario seleccionado.");
            return;
        }

        String sql = "INSERT INTO reserva (idMesa, nombreCliente, telefono, comensales, sector, fechaHora, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, reserva.getMesa().getIdMesa());
            ps.setString(2, reserva.getNombreCliente());
            ps.setString(3, reserva.getTelefono());
            ps.setInt(4, reserva.getComensales());
            ps.setString(5, reserva.getSector());
            ps.setTimestamp(6, Timestamp.valueOf(reserva.getFechaHora()));
            ps.setBoolean(7, reserva.isEstado());

            ps.executeUpdate();

            mesaData.actualizarDisponibilidadMesa(reserva.getMesa().getIdMesa(), "Reservada", false);
            System.out.println("Reserva agregada con éxito.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar la reserva: " + ex.getMessage());
        }
    }

    // 3. Listar reservas
    public List<Reserva> listarReservas() {
        List<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reserva";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Reserva reserva = crearReservaDesdeResultSet(rs); // Usar el método auxiliar
                reservas.add(reserva);
            }
        } catch (SQLException ex) {
            
        }

        return reservas;
    }

    // 4. Método para verificar disponibilidad de la mesa en un rango de tiempo de 2 horas
    public boolean verificarDisponibilidad(int idMesa, LocalDateTime fechaHora) {
        Mesa mesa = mesaData.buscarMesa(idMesa);

        if (mesa == null || !"Libre".equalsIgnoreCase(mesa.getSituacion()) || !mesa.isEstado()) {
            JOptionPane.showMessageDialog(null, "La mesa no está disponible. Situación actual: " + mesa.getSituacion() + ", Estado: " + (mesa.isEstado() ? "Activo" : "Inactivo"));
            return false;
        }

        String sql = "SELECT COUNT(*) FROM reserva WHERE idMesa = ? AND estado = true " +
                     "AND (fechaHora BETWEEN ? AND ?)";
        LocalDateTime fechaHoraFin = fechaHora.plusHours(2);

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idMesa);
            ps.setTimestamp(2, Timestamp.valueOf(fechaHora));
            ps.setTimestamp(3, Timestamp.valueOf(fechaHoraFin));

            ResultSet rs = ps.executeQuery();
            return rs.next() && rs.getInt(1) == 0; // True si no hay reservas en el intervalo
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al verificar disponibilidad: " + ex.getMessage());
        }

        return false;
    }

    // 5. Método auxiliar para crear una Reserva desde el ResultSet
    private Reserva crearReservaDesdeResultSet(ResultSet rs) throws SQLException {
        Reserva reserva = new Reserva();
        reserva.setIdReserva(rs.getInt("idReserva"));
        reserva.setFechaHora(rs.getTimestamp("fechaHora").toLocalDateTime());
        reserva.setMesa(new MesaData(con).buscarMesa(rs.getInt("idMesa")));
        reserva.setNombreCliente(rs.getString("nombreCliente"));
        reserva.setTelefono(rs.getString("telefono"));
        reserva.setComensales(rs.getInt("comensales"));
        reserva.setSector(rs.getString("sector"));
        reserva.setEstado(rs.getBoolean("estado"));
        return reserva;
    }

    // 6. Método para modificar una reserva
    public boolean modificarReserva(Reserva reserva) {
        // Verificar disponibilidad de la mesa
        if (!verificarDisponibilidad(reserva.getMesa().getIdMesa(), reserva.getFechaHora())) {
            
            return false;
        }

        // Verificar que la mesa exista en la base de datos
        Mesa mesaSeleccionada = mesaData.buscarMesa(reserva.getMesa().getIdMesa());
        if (mesaSeleccionada == null) {
            JOptionPane.showMessageDialog(null, "La mesa seleccionada no existe.");
            return false;
        }

        // Verificar que la mesa esté en el sector especificado
        if (!mesaSeleccionada.getSector().equalsIgnoreCase(reserva.getSector())) {
            JOptionPane.showMessageDialog(null, "La mesa seleccionada no pertenece al sector especificado.");
            return false;
        }

        // Verificar que la mesa esté en situación "libre" y en estado activo
        if (!mesaSeleccionada.isEstado() || !"libre".equalsIgnoreCase(mesaSeleccionada.getSituacion())) {
            JOptionPane.showMessageDialog(null, "La mesa seleccionada no está disponible (no está libre o no está habilitada).");
            return false;
        }

        // Si pasa todas las verificaciones, proceder con la modificación
        String sql = "UPDATE reserva SET idMesa = ?, nombreCliente = ?, telefono = ?, comensales = ?, sector = ?, fechaHora = ?, estado = ? WHERE idReserva = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, reserva.getMesa().getIdMesa());
            ps.setString(2, reserva.getNombreCliente());
            ps.setString(3, reserva.getTelefono());
            ps.setInt(4, reserva.getComensales());
            ps.setString(5, reserva.getSector());
            ps.setTimestamp(6, Timestamp.valueOf(reserva.getFechaHora()));
            ps.setBoolean(7, reserva.isEstado());
            ps.setInt(8, reserva.getIdReserva());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Reserva actualizada exitosamente.");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la reserva: " + e.getMessage());
            return false;
        }
    }

    // 7. Método para obtener reservas por estado
    public List<Reserva> obtenerReservasPorEstado(boolean estado) {
        List<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reserva WHERE estado = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setBoolean(1, estado);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    reservas.add(crearReservaDesdeResultSet(rs));
                }
            }
        } catch (SQLException ex) {
            
        }
        return reservas;
    }

    //8. Método para obtener reservas en un rango de fecha y hora
    public List<Reserva> obtenerReservasPorRangoFechaHora(LocalDateTime inicio, LocalDateTime fin) {
        List<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reserva WHERE fechaHora BETWEEN ? AND ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setTimestamp(1, Timestamp.valueOf(inicio));
            ps.setTimestamp(2, Timestamp.valueOf(fin));
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    reservas.add(crearReservaDesdeResultSet(rs));
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener reservas por rango de fecha y hora: " + ex.getMessage());
        }
        return reservas;
    }

     // 9. Buscar reserva por ID
    public Reserva obtenerReservaPorId(int id) {
        String sql = "SELECT * FROM reserva WHERE idReserva = ?";
        Reserva reserva = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    reserva = crearReservaDesdeResultSet(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la reserva: " + e.getMessage());
        }
        return reserva;
    }

    // 10. Obtener reserva por Nombre del Cliente
    public List<Reserva> obtenerReservaPorNombre(String nombreCliente) {
        List<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reserva WHERE nombreCliente LIKE ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombreCliente + "%"); // Filtrar nombres que comienzan con el texto ingresado

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    reservas.add(crearReservaDesdeResultSet(rs));
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar reservas por nombre: " + ex.getMessage());
        }

        return reservas;
    }

    // 11. Alta logica reserva
    public void altaLogicaReserva(int id){
        String sql = "UPDATE reserva SET estado = TRUE WHERE idReserva = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int filasAfectadas = ps.executeUpdate();

            //verificaciones de cambios
            if (filasAfectadas > 0) {
                System.out.println("Se dio de alta la reserva ");
            } else {
                System.out.println("No se encontro la reserva");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al activar la reserva: " + e.getMessage());
        }
    }
    
    // 12. Baja logica reserva
    public void bajaLogicaReserva(int id){
        String sql = "UPDATE reserva SET estado = FALSE WHERE idReserva = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int filasAfectadas = ps.executeUpdate(); 

            if (filasAfectadas > 0) {
                System.out.println("La reserva " + id + " fue dada de baja.");
            } else {
                System.out.println("No se encontró la reserva con ID: " + id);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al desactivar la reserva: " + e.getMessage());
        }
    }

    // 13. Obtener reservas por sector
    public List<Reserva> obtenerReservasPorSector(String sector) {
        List<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reserva WHERE sector = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, sector);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Reserva reserva = crearReservaDesdeResultSet(rs);
                reservas.add(reserva);
            }
        } catch (SQLException ex) {
            
        }

        return reservas;
    }

    // 14. Obtener reservas por cantidad de comensales
    public List<Reserva> obtenerReservasPorComensales(int comensales) {
        List<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reserva WHERE comensales = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, comensales);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Reserva reserva = crearReservaDesdeResultSet(rs);
                reservas.add(reserva);
            }
        } catch (SQLException ex) {
           
        }

        return reservas;
    }


}
