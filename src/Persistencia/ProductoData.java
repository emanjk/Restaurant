
package Persistencia;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProductoData {
    //Atributo
    private Connection con; 

    //Constructor
    public ProductoData(Connection connection) {
        this.con = connection; //Conexión a la base de datos
    }

    
    
    
    // 1. Guardar 'producto'
    public void guardarProducto(Producto producto) {
        String sql = "INSERT INTO producto (codigo, nombre, tipo, descripcion, precio, stock, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getTipo());
            ps.setString(4, producto.getDescripcion());
            ps.setDouble(5, producto.getPrecio());
            ps.setInt(6, producto.getStock());
            ps.setBoolean(7, producto.isEstado());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    producto.setIdProducto(rs.getInt(1)); //asignar el ID
                }
            }

            System.out.println("Producto guardado exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el producto: " + e.getMessage());
        }
    }
  
    // 2. Buscar 'producto' por ID
    public Producto buscarProductoPorId(int idProducto) {
        String sql = "SELECT * FROM producto WHERE idProducto = ?";
        Producto producto = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idProducto); 

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Crea y llena el objeto Producto con los datos de la base de datos
                    producto = new Producto();
                    producto.setIdProducto(rs.getInt("idProducto"));
                    producto.setCodigo(rs.getInt("codigo"));
                    producto.setNombre(rs.getString("nombre"));
                    producto.setTipo(rs.getString("tipo"));
                    producto.setDescripcion(rs.getString("descripcion"));
                    producto.setPrecio(rs.getDouble("precio"));
                    producto.setStock(rs.getInt("stock"));
                    producto.setEstado(rs.getBoolean("estado"));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar el producto: " + e.getMessage());
        }

        return producto; // Retorna 'producto' o 'null' si no lo encontro.
}
  
    //3. Buscar producto por codigo
    public Producto buscarProductoPorCodigo(int codigo) {
        String sql = "SELECT * FROM producto WHERE codigo = ?";
        Producto producto = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, codigo);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    producto = crearProductoDesdeResultSet(rs); // Crea y llena el objeto Producto
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar el producto: " + e.getMessage());
        }

        return producto; // Retorna el producto o null si no lo encontró
    }
    
    // 4. Modificar 'producto'
    public void modificarProducto(Producto producto){
        String sql = "UPDATE producto SET codigo = ?, nombre = ?, tipo = ?, descripcion = ?, precio = ?, stock = ?, estado = ? WHERE idProducto = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getTipo());
            ps.setString(4, producto.getDescripcion());
            ps.setDouble(5, producto.getPrecio());
            ps.setInt(6, producto.getStock());
            ps.setBoolean(7, producto.isEstado());
            ps.setInt(8, producto.getIdProducto()); // ID del producto a modificar

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Producto modificado exitosamente.");
            } else {
                System.out.println("No se encontró el producto con ID: " + producto.getIdProducto());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el producto: " + e.getMessage());
        }
    }
   
    // 5. Buscar 'producto' por nombre (LIKE)
    public List<Producto> buscarProductoPorNombre(String nombre) {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM producto WHERE nombre LIKE ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + nombre + "%");
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Producto producto = crearProductoDesdeResultSet(resultSet);
                productos.add(producto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar productos por nombre: " + ex.getMessage());
        }

        return productos;
    }

    // 6. Buscar 'producto' por precio (Rango)
    public List<Producto> buscarProductoPorPrecio(double precioMin, double precioMax) {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM producto WHERE precio BETWEEN ? AND ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDouble(1, precioMin);
            ps.setDouble(2, precioMax);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Producto producto = crearProductoDesdeResultSet(resultSet);
                productos.add(producto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar productos por precio: " + ex.getMessage());
        }

        return productos;
    }

    // 7. Buscar 'producto' por tipo
    public List<Producto> buscarProductoPorTipo(String tipo) {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM producto WHERE tipo = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, tipo);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Producto producto = crearProductoDesdeResultSet(resultSet);
                productos.add(producto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar productos por tipo: " + ex.getMessage());
        }

        return productos;
    }

    // 8. Buscar 'producto' por stock
    public List<Producto> buscarProductoPorStock(int stockMin, int stockMax) {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM producto WHERE stock BETWEEN ? AND ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, stockMin);
            ps.setInt(2, stockMax);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Producto producto = crearProductoDesdeResultSet(resultSet);
                productos.add(producto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar productos por stock: " + ex.getMessage());
        }

        return productos;
    }

    // 9. Método auxiliar para crear un objeto Producto desde el ResultSet
    private Producto crearProductoDesdeResultSet(ResultSet resultSet) throws SQLException {
        return new Producto(
            resultSet.getInt("idProducto"),
            resultSet.getInt("codigo"),
            resultSet.getString("nombre"),
            resultSet.getString("tipo"),
            resultSet.getString("descripcion"),
            resultSet.getDouble("precio"),
            resultSet.getInt("stock"),
            resultSet.getBoolean("estado")
        );
    }
    
    // 10. Método para listar todos los productos ordenados por tipo
    public List<Producto> mostrarMenu() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM producto ORDER BY tipo";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                // Crear un objeto Producto con los datos obtenidos
                Producto producto = crearProductoDesdeResultSet(rs);
                // Agregar el producto a la lista
                productos.add(producto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar los productos ordenados por tipo: " + ex.getMessage());
        }

        return productos;
    }
    
    // 11. Alta logica producto
    public void altaLogicaProducto(int id){
        String sql = "UPDATE producto SET estado = ? WHERE idProducto = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setBoolean(1, true); // Cambia el estado a activo
            ps.setInt(2, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("El producto ah sido dado de Alta! ");
            } else {
                System.out.println("No se encontró el producto con ID: " + id);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al activar el producto: " + e.getMessage());
        }
    }
    
    // 12. Baja logica producto
    public void bajaLogicaProducto(int id){
        String sql = "UPDATE producto SET estado = ? WHERE idProducto = ?"; // Suponiendo que 'estado' es un booleano

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setBoolean(1, false); // cambia a false
            ps.setInt(2, id); 

            int filasActualizadas = ps.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Producto dado de baja exitosamente.");
            } else {
                System.out.println("No se encontró el producto con el ID proporcionado.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al dar de baja el producto: " + e.getMessage());
        }

    }
    
    //13. Eliminar producto
    public void eliminarProducto(int id){
        String sql = "DELETE FROM producto WHERE idProducto = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id); // ID del producto a eliminar.

            int filasEliminadas = ps.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("Producto eliminado exitosamente.");
            } else {
                System.out.println("No se encontró el producto con el ID proporcionado.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el producto: " + e.getMessage());
        }
    }
    
    //14. Listar tipos de productos 
    public List<String> mostrarTipos() {
        List<String> tipos = new ArrayList<>();
        String sql = "SELECT tipo FROM producto";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                // Crear un objeto Producto con los datos obtenidos
                String tipo = rs.getString("tipo");
                // Agregar el producto a la lista
                tipos.add(tipo);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar los tipos de productos: " + ex.getMessage());
        }

        return tipos;
    }
        
    //15. Método para listar todos los productos
    public List<Producto> listarProductos() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM producto";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                // Crear un objeto Producto con los datos obtenidos
                Producto producto = crearProductoDesdeResultSet(rs);
                // Agregar el producto a la lista
                productos.add(producto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar los productos: " + ex.getMessage());
        }

        return productos;
    }

    //16.
    public List<Producto> listarProductosPorEstado(boolean estado) {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM producto WHERE estado = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setBoolean(1, estado); // Establece el estado como parámetro de búsqueda

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    // Crear un objeto Producto con los datos obtenidos
                    Producto producto = crearProductoDesdeResultSet(rs);
                    // Agregar el producto a la lista
                    productos.add(producto);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar productos por estado: " + ex.getMessage());
        }

        return productos;
    }
    
    //17.
    public List<String> obtenerNombresDeProductos() {
        List<String> nombresProductos = new ArrayList<>();
        String sql = "SELECT nombre FROM producto";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                nombresProductos.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener nombres de productos: " + e.getMessage());
        }

        return nombresProductos;
    }

    
    // Metodo adicional
    
    public Producto buscarProductoPorNombreExacto(String nombre) {
    Producto producto = null; // Inicializamos el producto en null
    String sql = "SELECT * FROM producto WHERE nombre = ?"; // Consulta SQL

    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, nombre); // Reemplazamos el parámetro de la consulta con el nombre del producto
        ResultSet resultSet = ps.executeQuery();

        // Si se encuentra un resultado, se asigna el producto
        if (resultSet.next()) {
            producto = crearProductoDesdeResultSet(resultSet);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al buscar producto por nombre exacto: " + ex.getMessage());
    }

    return producto; // Devolvemos el producto encontrado o null si no existe
}
    
    
}
    
    


