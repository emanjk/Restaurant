
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
    // Atributo
    private Connection con; // Conexión a la base de datos

    // Constructor
    public MeseroData(Connection connection) {
        this.con = connection; // Asigna la conexión proporcionada
    }
    
    
    // 1. Guardar Mesero nuevo
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
            
            JOptionPane.showMessageDialog(null,"Mesero guardado con éxito");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar mesero: " + ex.getMessage());
        }
    }
 
    // 2. Buscar mesero por ID
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
                JOptionPane.showMessageDialog(null, "No se encontró un mesero con el ID: " + idMesero);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar el mesero por ID: " + ex.getMessage());
        }

        return mesero;
    }
    
    // 3. Buscar mesero por DNI
    public Mesero buscarMeseroPorDni(int dni) {
        Mesero mesero = null;
        String sql = "SELECT * FROM mesero WHERE dni = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, dni);
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
                JOptionPane.showMessageDialog(null,"No se encontró un mesero con el DNI: " + dni);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar el mesero por DNI: " + ex.getMessage());
        }

        return mesero;
    }
    
    
   // 4. Modificar mesero
    public void modificarMesero(Mesero mesero){
        String sql = "UPDATE mesero SET nombre = ?, dni = ?, telefono = ?, email = ?, fechaRegistro = ?, turno = ?, sector = ?, estado = ? WHERE idMesero = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            // Asignamos los valores de los atributos del mesero al PreparedStatement
            ps.setString(1, mesero.getNombre());
            ps.setInt(2, mesero.getDni());
            ps.setString(3, mesero.getTelefono());
            ps.setString(4, mesero.getEmail());
            ps.setDate(5, java.sql.Date.valueOf(mesero.getFechaRegistro())); // Convertimos LocalDate a java.sql.Date
            ps.setString(6, mesero.getTurno());
            ps.setString(7, mesero.getSector());
            ps.setBoolean(8, mesero.getEstado());
            ps.setInt(9, mesero.getIdMesero()); // Indicamos el ID del mesero a modificar

            // Ejecutamos la actualización
            int filasAfectadas = ps.executeUpdate();


            if (filasAfectadas > 0) {
                 JOptionPane.showMessageDialog(null, "Mesero modificado exitosamente. ");
            } else {
               JOptionPane.showMessageDialog(null, "No se encontró un mesero con el ID: " + mesero.getIdMesero());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar el mesero: " + ex.getMessage());
        }


        }


    // 5. Alta logica Mesero
    public void altaLogicaMesero(int id){
          String sql = "UPDATE mesero SET estado = ? WHERE idMesero = ?";

    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setBoolean(1, true); //mesero activo
        ps.setInt(2, id);

        int filasAfectadas = ps.executeUpdate();

        if (filasAfectadas > 0) {
            JOptionPane.showMessageDialog(null, "Mesero dado de alta correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un mesero con el ID: " + id);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al dar de alta el mesero: " + ex.getMessage());
    }
    }

    // 6. Baja logica Mesero
    public void bajaLogicaMesero(int id) {
        String sql = "UPDATE mesero SET estado = ? WHERE idMesero = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setBoolean(1, false); // mesero inactivo
            ps.setInt(2, id); 

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Mesero dado de baja correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró un mesero con el ID: " + id);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de baja el mesero: " + ex.getMessage());
        }

    }
    
    // 7. Listar meseros
    public List<Mesero> listarMeseros(){
        List<Mesero> meseros = new ArrayList<>(); // Inicializamos la lista para almacenar meseros
        String sql = "SELECT * FROM mesero WHERE estado = ?";  //solo meseros activos

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setBoolean(1, true); 

            ResultSet rs = ps.executeQuery(); 

            while (rs.next()) {
                Mesero mesero = new Mesero(
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
                meseros.add(mesero); // Agregamos el mesero a la lista
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar los meseros: " + ex.getMessage());
        }

        return meseros; 
    
    }
    
    // 8. Eliminar mesero por ID
    public void eliminarMesero(int id){
        String sql = "DELETE FROM mesero WHERE idMesero = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);  // Asignamos el ID del mesero a eliminar

            int filasAfectadas = ps.executeUpdate();  // Ejecutamos la eliminación

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Mesero eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró un mesero con el ID: " + id);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el mesero: " + ex.getMessage());
        }
        }
    
}

