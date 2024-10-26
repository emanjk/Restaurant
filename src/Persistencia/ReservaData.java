package Persistencia;


import Modelo.Mesa;
import Modelo.Reserva;
import Persistencia.MesaData; 

//clases de la API JDBC
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ReservaData {
    //Atributo
    private Connection con; 
    private MesaData mesaData;

   //Constructor
    public ReservaData(Connection connection) {
        this.con = connection; 
        this.mesaData= new MesaData(con);// Unica instancia.
    }

    // Método auxiliar para crear una Reserva desde el ResultSet
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

    
    
    // 1. Guardar Reserva
    public void agregarReserva(Reserva reserva) {
        String sql = "INSERT INTO reserva (fechaHora, idMesa, nombreCliente, telefono, comensales, sector, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setTimestamp(1, Timestamp.valueOf(reserva.getFechaHora()));
            ps.setInt(2, reserva.getMesa().getIdMesa());
            ps.setString(3, reserva.getNombreCliente());
            ps.setString(4, reserva.getTelefono());
            ps.setInt(5, reserva.getComensales());
            ps.setString(6, reserva.getSector());
            ps.setBoolean(7, reserva.isEstado());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    reserva.setIdReserva(rs.getInt(1));
                }
            }
            JOptionPane.showMessageDialog(null, "Reserva agregada exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Error al agregar la reserva: " + e.getMessage());
        }
    }

    // 2. Buscar reserva por ID
    public Reserva buscarReservaPorId(int id) {
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

    // 3. Listar reservas
    public List<Reserva> listarReservas() {
        List<Reserva> reservas = new ArrayList<>(); 
        String sql = "SELECT * FROM reserva";   

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery(); // Ejecutar la consulta

            while (rs.next()) {
                // Crear un objeto Reserva y agregarlo a la lista
                Reserva reserva = new Reserva(
                    rs.getInt("idReserva"),
                    mesaData.buscarMesa(rs.getInt("idMesa")), // Obtener la mesa asociada
                    rs.getString("nombreCliente"),
                    rs.getString("telefono"),
                    rs.getInt("comensales"),
                    rs.getString("sector"),
                    rs.getTimestamp("fechaHora").toLocalDateTime(),
                    rs.getBoolean("estado")
                );
                reservas.add(reserva); // Agregar la reserva a la lista
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar reservas: " + ex.getMessage());
        }

        return reservas;
    }
    
    // 4. Modificar reserva 
    public void modificarReserva(Reserva reserva){
        String sql = "UPDATE reserva SET idMesa = ?, nombreCliente = ?, telefono = ?, comensales = ?, sector = ?, fechaHora = ?, estado = ? WHERE idReserva = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, reserva.getMesa().getIdMesa());
            ps.setString(2, reserva.getNombreCliente());
            ps.setString(3, reserva.getTelefono());
            ps.setInt(4, reserva.getComensales());
            ps.setString(5, reserva.getSector());
            ps.setTimestamp(6, Timestamp.valueOf(reserva.getFechaHora()));
            ps.setBoolean(7, reserva.isEstado());
            ps.setInt(8, reserva.getIdReserva()); // ID de la reserva que se va a actualizar

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Reserva actualizada exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al actualizar la reserva: " + e.getMessage());
        }
    }
    
    // 5. Obtener reserva por Nombre del Cliente
    public List<Reserva> obtenerReservaPorNombre(String nombreCliente) {
        List<Reserva> reservas = new ArrayList<>();

        String sql = "SELECT * FROM reserva WHERE nombreCliente LIKE ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + nombreCliente + "%"); 

            ResultSet rs = ps.executeQuery(); // Ejecutar la consulta

            while (rs.next()) {
                Reserva reserva = new Reserva(
                    rs.getInt("idReserva"),
                    mesaData.buscarMesa(rs.getInt("idMesa")), // Usando la instancia de mesaData
                    rs.getString("nombreCliente"),
                    rs.getString("telefono"),
                    rs.getInt("comensales"),
                    rs.getString("sector"),
                    rs.getTimestamp("fechaHora").toLocalDateTime(),
                    rs.getBoolean("estado")
                );
                reservas.add(reserva); // Agregar la reserva a la lista
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar reservas por nombre: " + ex.getMessage());
        }

        return reservas; // retorna null o true si encontro o no la reserva.
    }

    // 6. Obtener reserva por estado
    public List<Reserva> obtenerReservasPorEstado(boolean estado) {
        List<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reserva WHERE estado = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setBoolean(1, estado); 
            ResultSet rs = ps.executeQuery(); // Ejecutar la consulta

            while (rs.next()) {
               
                Reserva reserva = new Reserva(
                    rs.getInt("idReserva"),
                    mesaData.buscarMesa(rs.getInt("idMesa")), // Usar mesaData para obtener la mesa
                    rs.getString("nombreCliente"),
                    rs.getString("telefono"),
                    rs.getInt("comensales"),
                    rs.getString("sector"),
                    rs.getTimestamp("fechaHora").toLocalDateTime(),
                    rs.getBoolean("estado")
                );
                reservas.add(reserva); // Agregar la reserva a la lista
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar reservas por estado: " + ex.getMessage());
        }

        return reservas;
    }
    
    // 7. Obtener reservas por fecha y hora
    public List<Reserva> obtenerReservasPorFecha(LocalDateTime fechaHora) {
        List<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reserva WHERE fechaHora = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setTimestamp(1, java.sql.Timestamp.valueOf(fechaHora)); // Conversión a Timestamp
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Reserva reserva = new Reserva(
                    rs.getInt("idReserva"),
                   mesaData.buscarMesa(rs.getInt("idMesa")), // Método que debes implementar
                    rs.getString("nombreCliente"),
                    rs.getString("telefono"),
                    rs.getInt("comensales"),
                    rs.getString("sector"),
                    rs.getTimestamp("fechaHora").toLocalDateTime(),
                    rs.getBoolean("estado")
                );
                reservas.add(reserva);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar reservas por fecha: " + ex.getMessage());
        }

        return reservas;
}

 
    // 8. Eliminar reserva
    public void eliminarReserva(int id){
        String sql = "DELETE FROM reserva WHERE idReserva = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id); 
            int filasAfectadas = ps.executeUpdate(); 

            if (filasAfectadas > 0) {
                System.out.println("Reserva eliminada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null,"No se encontró una reserva con el ID especificado.");
            }
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null,"Error al eliminar la reserva: " + e.getMessage());
        }
    }
            
   

  
}
