package Persistencia;

import Modelo.Mesa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MesaData {

    private Connection connection;

    // Constructor que recibe la conexión
    public MesaData(Connection connection) {
        this.connection = connection;
    }

    // Guardar Mesa
    public void guardarMesa(Mesa mesa) {
        String sql = "INSERT INTO mesa (capacidad, estado, sector, situacion) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, mesa.getCapacidad());
            ps.setBoolean(2, mesa.isEstado());
            ps.setString(3, mesa.getSector());
            ps.setString(4, mesa.getSituacion());

            ps.executeUpdate();
            System.out.println("Mesa guardada con éxito");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar mesa: " + ex.getMessage());
        }
    }

    // Buscar Mesa
    public Mesa buscarMesa(int id) {
        Mesa mesa = null;
        String sql = "SELECT * FROM mesa WHERE idMesa = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                mesa = new Mesa(
                    resultSet.getInt("idMesa"),
                    resultSet.getInt("capacidad"),
                    resultSet.getBoolean("estado"),
                    resultSet.getString("sector"),
                    resultSet.getString("situacion") // Añade situacion
                );
            } else {
                System.out.println("No se encontró ninguna Mesa con ID: " + id);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar mesa: " + ex.getMessage());
        }
        return mesa;
    }

    // Modificar Mesa
    public void modificarMesa(Mesa mesa) {
        String sql = "UPDATE mesa SET capacidad = ?, estado = ?, sector = ?, situacion = ? WHERE idMesa = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, mesa.getCapacidad());
            ps.setBoolean(2, mesa.isEstado());
            ps.setString(3, mesa.getSector());
            ps.setString(4, mesa.getSituacion()); // Añade situacion
            ps.setInt(5, mesa.getIdMesa());

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Mesa modificada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "La mesa no existe.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar mesa: " + ex.getMessage());
        }
    }
}
