
package Persistencia;
import Persistencia.Conexion;
import Modelo.Mesa; // 1. Importamos la clase Alumno
import java.sql.Connection; //2. Conexion a bd 'universidadulp
import java.sql.PreparedStatement; //3. 'Declaracion preparada', permite ejecutar consultas SQL
import java.sql.ResultSet; //4. Contiene o Guarda los resultados de la consulta SQL ejecutada por PreparedStatement o Statement
import java.sql.SQLException; // 5. Clase para manejar errores relacionados a operaciones con SQL.
import java.sql.Date;

import java.util.ArrayList;
import java.time.LocalDate;

import java.util.List;
import javax.swing.JOptionPane;

public class MesaData {
     //(1) 'con' almacena la conexion a la bd
    private Connection con=null ;
    
    
     //(2) constructor que recibe la conexion
    public MesaData(Conexion conexion) {   
        this.con = conexion.buscarConexion();           
    }
 
    
    
       //Metodos para consultar la BDS-restotf, tabla: mesa
    
    //Guardar Mesa
    public void guardarMesa(Mesa mesa) {
        String sql = "INSERT INTO mesa (capacidad, estado, sector) VALUES (?, ?, ?)";

    try {
        PreparedStatement ps = con.prepareStatement(sql); /*tiene la conexion a la bd 'universidadulp y la consulta SQL*/

        //obtenemos los datos de la bd 'rest'
        ps.setInt(1, mesa.getCapacidad()); 
        ps.setBoolean(2, mesa.isEstado()); 
        ps.setString(3, mesa.getSector());   
        
        ps.executeUpdate();
        System.out.println("Mesa guardado con éxito");
        
    }
    
        catch (SQLException ex) {
            ex.printStackTrace();  
            JOptionPane.showMessageDialog(null, "Error al guardar mesa: " + ex.getMessage());
        }
           
    }
    
    
    //Buscar Mesa
    public Mesa buscarMesa (int id){
        Mesa mesa = null;  // Inicializamos el objeto Mesa como null
        String sql = "SELECT * FROM mesa WHERE idMesa = ?";
    
        try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);  // Asignamos el parámetro ID

        ResultSet resultSet = ps.executeQuery();  // Ejecutamos la consulta

        // Si se encuentra una mesa con el ID dado
        if (resultSet.next()) {

                mesa = new Mesa(
                resultSet.getInt("capacidad"),
                resultSet.getBoolean("estado"),
                resultSet.getString("sector")
               
                );
            
            mesa.setIdMesa(resultSet.getInt("idMesa"));
        } else {
            System.out.println("No se encontró ningúna Mesa" + id);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al buscar mesa : " + ex.getMessage());
    }
    
    return mesa; 
     
    }
    
    
    
    
    //Modificar Mesa
    public void modificarMesa(Mesa mesa){
        String sql = "UPDATE mesa SET  capacidad = ?, estado = ?, sector = ?";
        PreparedStatement ps = null;
    
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, mesa.getCapacidad());
            ps.setBoolean(2, mesa.isEstado());
            ps.setString(3, mesa.getSector());

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "La mesa no existe.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla mesa: " + ex.getMessage());
        }
        
        
    }

    
    public void altaLogicaMesa(Mesa mesa){
        String sql =  "UPDATE mesa SET estado=? WHERE idMesa = ?" ;
        try (PreparedStatement ps = con.prepareStatement(sql)) {
      
            ps.setBoolean(1, true);  // Establece el estado como falso (baja lógica)
            ps.setInt(2, mesa.getIdMesa()); // Establece el ID de la mesa en el segundo parámetro

            // Ejecutar la actualización!
            ps.executeUpdate();
            System.out.println("Alumno dado de baja correctamente.");
            
        }catch (SQLException ex) {
            ex.printStackTrace();
            /*chequear*/
        }        
        
    }
    

    public void bajaLogicaMesa(){
    }
    
    
    
    
    /*metodos adicionales*/
    public void ocuparMesa(){
        
    
    }
    


   
    
    
}
