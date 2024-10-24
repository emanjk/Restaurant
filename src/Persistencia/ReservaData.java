package Persistencia;

import Modelo.Reserva;
import Modelo.Mesa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservaData {
    private Connection con; // Conexión a la base de datos

    // Constructor que recibe la conexión
    public ReservaData(Connection connection) {
        this.con = connection; // Asigna la conexión proporcionada
    }

    // Método para agregar una nueva reserva
    public void agregarReserva(Reserva reserva) {
        String sql = "INSERT INTO reserva (fechaHora, idMesa, nombreCliente, cantidadPersonas) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setTimestamp(1, Timestamp.valueOf(reserva.getFechaHora())); // Convertir LocalDateTime a Timestamp
            ps.setInt(2, reserva.getMesa().getIdMesa());
            ps.setString(3, reserva.getNombreCliente());
            ps.setInt(4, reserva.getCantidadPersonas());

            ps.executeUpdate();

            // Obtener el ID generado
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
                    reserva = new Reserva();
                    reserva.setIdReserva(rs.getInt("idReserva"));
                    reserva.setFechaHora(rs.getTimestamp("fechaHora").toLocalDateTime()); // Convertir Timestamp a LocalDateTime
                    reserva.setMesa(new MesaData(con).buscarMesa(rs.getInt("idMesa"))); // Obtener la mesa asociada
                    reserva.setNombreCliente(rs.getString("nombreCliente"));
                    reserva.setCantidadPersonas(rs.getInt("cantidadPersonas"));
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
                Reserva reserva = new Reserva();
                reserva.setIdReserva(rs.getInt("idReserva"));
                reserva.setFechaHora(rs.getTimestamp("fechaHora").toLocalDateTime()); // Convertir Timestamp a LocalDateTime
                reserva.setMesa(new MesaData(con).buscarMesa(rs.getInt("idMesa"))); // Obtener la mesa asociada
                reserva.setNombreCliente(rs.getString("nombreCliente"));
                reserva.setCantidadPersonas(rs.getInt("cantidadPersonas"));

                reservas.add(reserva);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener las reservas: " + e.getMessage());
        }
        return reservas;
    }

    // Método para actualizar una reserva existente
    public void actualizarReserva(Reserva reserva) {
        String sql = "UPDATE reserva SET fechaHora = ?, idMesa = ?, nombreCliente = ?, cantidadPersonas = ? WHERE idReserva = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setTimestamp(1, Timestamp.valueOf(reserva.getFechaHora())); // Convertir LocalDateTime a Timestamp
            ps.setInt(2, reserva.getMesa().getIdMesa());
            ps.setString(3, reserva.getNombreCliente());
            ps.setInt(4, reserva.getCantidadPersonas());
            ps.setInt(5, reserva.getIdReserva());

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

    // Método para eliminar una reserva por ID
    public void eliminarReserva(int id) {
        String sql = "DELETE FROM reserva WHERE idReserva = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Reserva eliminada exitosamente.");
            } else {
                System.out.println("No se encontró la reserva con ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar la reserva: " + e.getMessage());
        }
    }
}
