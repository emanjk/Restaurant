
package Persistencia;

import Modelo.Mesero;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class MeseroData {
    
    private Connection connection= null;

    // Constructor que recibe la conexión
    public MeseroData(Conexion conexion) {
        this.connection = conexion.buscarConexion();
    }
    
    // Guardar Mesero nuevo
    public void guardarMesero(Mesero mesero) {
        String sql = "INSERT INTO mesero (idMesero, nombre, dni, telefono, email, fechaRegistro, turno, sector, estado)) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, mesero.getIdMesero());
            ps.setString(2, mesero.getNombre());
            ps.setInt(3, mesero.getDni());
            ps.setString(4, mesero.getTelefono());
            ps.setString(5, mesero.getEmail());
            // Convertir java.sql.Date a LocalDate
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
    
    
}
