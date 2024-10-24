package Persistencia;


import Modelo.Mesa;
import Modelo.Reserva;
import Persistencia.MesaData;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservaData {
    private Connection con; // Conexión a la base de datos

    // Constructor que recibe la conexión
    public ReservaData(Connection connection) {
        this.con = connection;
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

    // Método para agregar una nueva reserva
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
            System.out.println("Reserva agregada exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al agregar la reserva: " + e.getMessage());
        }
    }

    // Método para obtener una reserva por ID
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

    // Método para obtener todas las reservas
    public List<Reserva> obtenerReservas() {
        String sql = "SELECT * FROM reserva";
        List<Reserva> reservas = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                reservas.add(crearReservaDesdeResultSet(rs));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener las reservas: " + e.getMessage());
        }
        return reservas;
    }

    // Método para actualizar una reserva existente
    public void actualizarReserva(Reserva reserva) {
        String sql = "UPDATE reserva SET fechaHora = ?, idMesa = ?, nombreCliente = ?, telefono = ?, comensales = ?, sector = ?, estado = ? WHERE idReserva = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setTimestamp(1, Timestamp.valueOf(reserva.getFechaHora()));
            ps.setInt(2, reserva.getMesa().getIdMesa());
            ps.setString(3, reserva.getNombreCliente());
            ps.setString(4, reserva.getTelefono());
            ps.setInt(5, reserva.getComensales());
            ps.setString(6, reserva.getSector());
            ps.setBoolean(7, reserva.isEstado());
            ps.setInt(8, reserva.getIdReserva());

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Reserva actualizada exitosamente.");
            } else {
                System.out.println("No se encontró la reserva con ID: " + reserva.getIdReserva());
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar la reserva: " + e.getMessage());
        }
    }

    // Método para obtener reservas por fecha
    public List<Reserva> obtenerReservasPorFecha(LocalDate fecha) {
        String sql = "SELECT * FROM reserva WHERE DATE(fechaHora) = ?";
        List<Reserva> reservas = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, java.sql.Date.valueOf(fecha));

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    reservas.add(crearReservaDesdeResultSet(rs));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener las reservas por fecha: " + e.getMessage());
        }
        return reservas;
    }

    // Método para obtener reservas por estado
    public List<Reserva> obtenerReservasPorEstado(boolean estado) {
        String sql = "SELECT * FROM reserva WHERE estado = ?";
        List<Reserva> reservas = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setBoolean(1, estado);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    reservas.add(crearReservaDesdeResultSet(rs));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener las reservas por estado: " + e.getMessage());
        }
        return reservas;
    }

    // Método para obtener reservas por sector
    public List<Reserva> obtenerReservasPorSector(String sector) {
        String sql = "SELECT * FROM reserva WHERE sector = ?";
        List<Reserva> reservas = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, sector);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    reservas.add(crearReservaDesdeResultSet(rs));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener las reservas por sector: " + e.getMessage());
        }
        return reservas;
    }

    // Método para eliminar físicamente una reserva
    public void eliminarReserva(int idReserva) {
        String sql = "DELETE FROM reserva WHERE idReserva = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idReserva);
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Reserva eliminada físicamente.");
            } else {
                System.out.println("No se encontró la reserva con ID: " + idReserva);
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar la reserva: " + e.getMessage());
        }
    }
}
