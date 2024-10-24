
package Vista;
/*Importamos las clases de la API JDBC*/

import Modelo.Conexion;
import Modelo.Mesa;
import Persistencia.MesaData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet ; 
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestMain {
        private Conexion conexion ; // Variable para manejar la conexión a la base de datos
        private MesaData mesaData ;

    public TestMain() {
        conexion = new Conexion ("jdbc:mariadb://localhost:3306/restotf", "root", "");
        mesaData = new MesaData (conexion) ;
    }
    
    public static void main(String[] args) throws SQLException {
        TestMain main = new TestMain(); /*para acceder a mesaData xq es estatica*/

        Mesa nuevaMesa= new Mesa(14, true, "arriba", "libre");
        main.mesaData.guardarMesa(nuevaMesa);
        
       
   
        
        
        
        
        
        }
        
        
        
    
}
