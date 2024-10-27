package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    private static String url = "jdbc:mariadb://localhost/restotf"; // URL de la BD
    private static String usuario = "root";
    private static String password = "";
    private static Connection conexion = null;

    private Conexion() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar Driver: " + ex.getMessage());
        }
    }

    // Método para obtener la conexión a la base de datos
    public static Connection getConexion() {
        if (conexion == null) {
            try {
                conexion = DriverManager.getConnection(url, usuario, password);
                System.out.println("  Conexion Exitosa!  \n");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error de conexión: " + ex.getMessage());
            }
        }
        return conexion; // Retorna la conexión, incluso si es null
    }
}
