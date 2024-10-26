package Persistencia;

import Modelo.Conexion;
import Modelo.Mesa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MesaData {
    
    private Connection con; // Conexión a la base de datos

    // Constructor que recibe la conexión
    public MesaData(Connection connection) {
        this.con = connection; // Asigna la conexión proporcionada
    }
    
    
    
    
    // 1. Guardar Mesa
    public void guardarMesa(Mesa mesa) {
        String sql = "INSERT INTO mesa (capacidad, estado, sector, situacion) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, mesa.getCapacidad());
            ps.setBoolean(2, mesa.isEstado());
            ps.setString(3, mesa.getSector());
            ps.setString(4, mesa.getSituacion());

            ps.executeUpdate();
            System.out.println("Mesa guardada con éxito");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al guardar mesa: " + ex.getMessage());
           
        }
    }

    // 2. Buscar Mesa por ID
    public Mesa buscarMesa(int id) {
        Mesa mesa = null;
        String sql = "SELECT * FROM mesa WHERE idMesa = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                mesa = new Mesa(
                    resultSet.getInt("idMesa"),
                    resultSet.getInt("capacidad"),
                    resultSet.getBoolean("estado"),
                    resultSet.getString("sector"),
                    resultSet.getString("situacion")
                );
            } else {
                System.out.println( "No se encontró la mesa con ID: " + id);
            }
        } catch (SQLException ex) {
            System.out.println( "Error al buscar mesa: " + ex.getMessage());
        }
        return mesa;
    }


    // 3. Modificar Mesa
    public void modificarMesa(Mesa mesa) {
        // Consulta SQL para actualizar la mesa
        String sql = "UPDATE mesa SET capacidad = ?, estado = ?, sector = ?, situacion = ? WHERE idMesa = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            // Asignar valores a los parámetros de la consulta
            ps.setInt(1, mesa.getCapacidad());
            ps.setBoolean(2, mesa.isEstado());
            ps.setString(3, mesa.getSector());
            ps.setString(4, mesa.getSituacion());
            ps.setInt(5, mesa.getIdMesa());

            // devuelve 0 si no se modifico.
            int filasActualizadas = ps.executeUpdate();
            
            if (filasActualizadas > 0) {
                System.out.println("Mesa modificada exitosamente.");
                System.out.println("Mesa modificada: ID=" + mesa.getIdMesa() +
                    ", Capacidad=" + mesa.getCapacidad() + ", Estado=" + mesa.isEstado() +
                    ", Sector=" + mesa.getSector() + ", Situación=" + mesa.getSituacion());
            } else {
                System.out.println( "No se encontró la mesa con el ID proporcionado.");
                System.out.println("No se encontró la mesa con ID: " + mesa.getIdMesa());
            }
        } catch (SQLException ex) {
            System.out.println ( "Error al modificar mesa: " + ex.getMessage());
            ex.printStackTrace(); // Mostrar la traza de error para más detalles
        }
    }

   
     // 4. Alta lógica de una mesa
    public void altaLogicaMesa(int idMesa) {
        String sql = "UPDATE mesa SET estado = ? WHERE idMesa = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setBoolean(1, true); // Cambiar el estado a activo (true)
            ps.setInt(2, idMesa);

            int filasActualizadas = ps.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Mesa reactivada exitosamente.");
            } else {
                System.out.println( "No se encontró la mesa con el ID proporcionado.");
            }
        } catch (SQLException ex) {
            System.out.println( "Error al realizar el alta lógica de la mesa: " + ex.getMessage());
        }
    }
    
    // 5. Baja lógica de una mesa
    public void bajaLogicaMesa(int idMesa) {
        String sql = "UPDATE mesa SET estado = ? WHERE idMesa = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setBoolean(1, false); // Cambiar el estado a inactivo (false)
            ps.setInt(2, idMesa);

            int filasActualizadas = ps.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println( "Mesa dada de baja lógicamente.");
            } else {
                System.out.println( "No se encontró la mesa con el ID proporcionado.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al realizar la baja lógica de la mesa: " + ex.getMessage());
        }
    }

    // 6. Listar todas las mesas
    public List<Mesa> listarMesas() {
        List<Mesa> mesas = new ArrayList<>();
        String sql = "SELECT * FROM mesa";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Mesa mesa = new Mesa(
                    rs.getInt("idMesa"),
                    rs.getInt("capacidad"),
                    rs.getBoolean("estado"),
                    rs.getString("sector"),
                    rs.getString("situacion")
                );
                mesas.add(mesa);
            }
        } catch (SQLException ex) {
            System.out.println( "Error al listar mesas: " + ex.getMessage());
        }

        return mesas;
    }
   
    // 7. Listar mesas por 'sector'
    public List<Mesa> listarMesasPorSector(String sector){
        List<Mesa> mesas = new ArrayList<>();
        String sql = "SELECT * FROM mesa WHERE sector = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, sector);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Mesa mesa = new Mesa(
                    rs.getInt("idMesa"),
                    rs.getInt("capacidad"),
                    rs.getBoolean("estado"),
                    rs.getString("sector"),
                    rs.getString("situacion")
                );
                mesas.add(mesa); 
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar mesas por sector: " + ex.getMessage());
        }

            return mesas; 
        }
    
   
    // 8. Listar mesas por 'situacion'
    public List<Mesa> buscarMesasPorSituacion(String situacion) {
        List<Mesa> mesas = new ArrayList<>();
        String sql = "SELECT * FROM mesa WHERE situacion = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, situacion);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Mesa mesa = new Mesa(
                    rs.getInt("idMesa"),
                    rs.getInt("capacidad"),
                    rs.getBoolean("estado"),
                    rs.getString("sector"),
                    rs.getString("situacion")
                );
                mesas.add(mesa);
            }
        } catch (SQLException ex) {
            System.out.println( "Error al buscar mesas por situación: " + ex.getMessage());
        }

        return mesas;
    }
    
    // 9. Eliminar mesa por ID
    public void eliminarMesa(int id){
        String sql = "DELETE FROM mesa WHERE idMesa = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id); // id de mesa.

            int filasAfectadas = ps.executeUpdate();//Ejecucion.

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Mesa eliminada correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró una mesa con el ID: " + id);
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la mesa: " + ex.getMessage());
          }

    }
    
    
}
