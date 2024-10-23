
package Modelo;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion { 
    
    //(1)Atributo para la conexión
    private String url = "jdbc:mariadb://localhost/restotf";
    private static String usuario = "root";
    private static String password = "";
    
    
    private static Connection conexion = null ; //conexion estatica, se crea una sola vez
  
     
    //(2)Constructor 
    public Conexion(String url, String usr, String pass) {
        this.url = url;
        this.usuario = usr;
        this.password = pass;
    }
    
    
    //(3)metodo 'buscarConexion'   
    public Connection buscarConexion(){  
        
      if(conexion == null){ //si es la primera vez
        try{
            
          //(1) Cargamos el Driver 
          Class.forName("org.mariadb.jdbc.Driver"); // cargar el controlador JDBC (driver) de MariaDB en tiempo de ejecución.

          
          //(2) Conexion a nuestra base de datos (estatica)
          conexion = DriverManager.getConnection(url,usuario,password);//(2)'conexion' almacenará la conexión establecida.
          // A través de esta variable, se puede interactuar con la base de datos (realizar consultas, actualizaciones, etc.).

        }catch(SQLException | ClassNotFoundException ex){

            JOptionPane.showMessageDialog(null,"no se pudo conectar o cargar los Drivers " + ex.getMessage());
        }
        
      }
        
     return conexion ; //retorna la conexion establecida
    
    }
    
    // Método para cerrar la conexión
    public void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
                conexion = null; // reiniciar la conexión a null
                System.out.println("Conexión cerrada exitosamente.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }
    
    
}
