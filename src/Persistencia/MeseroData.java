
package Persistencia;

import Modelo.Mesero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MeseroData {
    
    
 
    private Connection con; // Conexión a la base de datos

    // Constructor que recibe la conexión
    public MeseroData(Connection connection) {
        this.con = connection; // Asigna la conexión proporcionada
    }
    
    // Guardar Mesero nuevo
    public void guardarMesero(Mesero mesero) {
        String sql = "INSERT INTO mesero (idMesero, nombre, dni, telefono, email, fechaRegistro, turno, sector, estado)) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, mesero.getIdMesero());
            ps.setString(2, mesero.getNombre());
            ps.setInt(3, mesero.getDni());
            ps.setString(4, mesero.getTelefono());
            ps.setString(5, mesero.getEmail());
            ps.setDate(6,java.sql.Date.valueOf( mesero.getFechaRegistro()));
            ps.setString(7, mesero.getTurno());
            ps.setString(8, mesero.getSector());
            ps.setBoolean(9, mesero.getEstado());
            

            ps.executeUpdate();
            System.out.println("Mesero guardado con éxito");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar mesero: " + ex.getMessage());
        }
    }
 

    // Método para buscar un mesero por nombre
    public Mesero buscarMeseroPorNombre(String nombre) {
        Mesero mesero = null;
        String sql = "SELECT * FROM mesero WHERE nombre = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                mesero = new Mesero(
                    rs.getInt("idMesero"),
                    rs.getString("nombre"),
                    rs.getInt("dni"),
                    rs.getString("telefono"),
                    rs.getString("email"),
                    rs.getDate("fechaRegistro").toLocalDate(),
                    rs.getString("turno"),
                    rs.getString("sector"),
                    rs.getBoolean("estado")
                );
            } else {
                System.out.println("No se encontró un mesero con el nombre: " + nombre);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar el mesero por nombre: " + ex.getMessage());
        }

        return mesero;
    }

    // Método para buscar un mesero por ID
    public Mesero buscarMeseroPorId(int idMesero) {
        Mesero mesero = null;
        String sql = "SELECT * FROM mesero WHERE idMesero = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idMesero);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                mesero = new Mesero(
                    rs.getInt("idMesero"),
                    rs.getString("nombre"),
                    rs.getInt("dni"),
                    rs.getString("telefono"),
                    rs.getString("email"),
                    rs.getDate("fechaRegistro").toLocalDate(),
                    rs.getString("turno"),
                    rs.getString("sector"),
                    rs.getBoolean("estado")
                );
            } else {
                System.out.println("No se encontró un mesero con el ID: " + idMesero);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar el mesero por ID: " + ex.getMessage());
        }

        return mesero;
    }
}


