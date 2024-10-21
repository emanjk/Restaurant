package Persistencia;

import Modelo.Mesa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MesaData {
    
    private Connection connection;

    // Constructor que recibe la conexión
    public MesaData(Connection connection) {
        this.connection = connection;
    }

    // Guardar Mesa
    public void guardarMesa(Mesa mesa) {
        String sql = "INSERT INTO mesa (capacidad, estado, sector) VALUES (?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) { 
            ps.setInt(1, mesa.getCapacidad());
            ps.setBoolean(2, mesa.isEstado());
            ps.setString(3, mesa.getSector());
            
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
                    resultSet.getInt("capacidad"),
                    resultSet.getBoolean("estado"),
                    resultSet.getString("sector")
                );
                mesa.setIdMesa(resultSet.getInt("idMesa"));
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
        String sql = "UPDATE mesa SET capacidad = ?, estado = ?, sector = ? WHERE idMesa = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, mesa.getCapacidad());
            ps.setBoolean(2, mesa.isEstado());
            ps.setString(3, mesa.getSector());
            ps.setInt(4, mesa.getIdMesa());

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

    // Alta lógica de Mesa
    public void altaLogicaMesa(int idMesa) {
        String sql = "UPDATE mesa SET estado = ? WHERE idMesa = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setBoolean(1, true);  // Establece el estado como verdadero (alta lógica)
            ps.setInt(2, idMesa);

            ps.executeUpdate();
            System.out.println("Mesa dada de alta correctamente.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al dar de alta la mesa: " + ex.getMessage());
        }        
    }

    // Baja lógica de Mesa
    public void bajaLogicaMesa(int idMesa) {
        String sql = "UPDATE mesa SET estado = ? WHERE idMesa = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setBoolean(1, false);  // Establece el estado como falso (baja lógica)
            ps.setInt(2, idMesa);

            ps.executeUpdate();
            System.out.println("Mesa dada de baja correctamente.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al dar de baja la mesa: " + ex.getMessage());
        }
    }

    // Método adicional: Ocupación de mesa
    public void ocuparMesa(int idMesa) {
        String sql = "UPDATE mesa SET estado = ? WHERE idMesa = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setBoolean(1, true);  // Establece el estado como ocupado
            ps.setInt(2, idMesa);

            ps.executeUpdate();
            System.out.println("Mesa ocupada correctamente.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al ocupar la mesa: " + ex.getMessage());
        }
    }
}
