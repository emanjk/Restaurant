
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
        this.con = connection; //Ahora podemos usar productoData para realizar operaciones en la BDS
    }

    // Método para dar de alta un producto (INSERT)
    public void nuevoProducto(Producto producto) {
        String sql = "INSERT INTO producto (codigo, nombre, tipo, descripcion, precio, stock, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getTipo());
            ps.setString(4, producto.getDescripcion());
            ps.setDouble(5, producto.getPrecio());
            ps.setInt(6, producto.getStock());
            ps.setBoolean(7, producto.isEstado());

            ps.executeUpdate();
            System.out.println("Producto dado de alta con éxito.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de alta el producto: " + ex.getMessage());
        }
    }


    // Método para modificar un producto (UPDATE)
    public void modificarProducto(Producto producto) {
        String sql = "UPDATE producto SET codigo = ?, nombre = ?, tipo = ?, descripcion = ?, precio = ?, stock = ?, estado = ? WHERE idProducto = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getTipo());
            ps.setString(4, producto.getDescripcion());
            ps.setDouble(5, producto.getPrecio());
            ps.setInt(6, producto.getStock());
            ps.setBoolean(7, producto.isEstado());
            ps.setInt(8, producto.getIdProducto());

            int resultado = ps.executeUpdate();
            if (resultado == 1) {
                System.out.println("Producto modificado con éxito.");
            } else {
                System.out.println("No se encontró el producto con ID: " + producto.getIdProducto());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar el producto: " + ex.getMessage());
        }
    }
    
     // Método para buscar productos por nombre (LIKE)
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

    // Método para buscar productos por precio (RANGO)
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

    // Método para buscar productos por tipo
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

    // Método para buscar productos por stock (RANGO)
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

    // Método auxiliar para crear un objeto Producto desde el ResultSet
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
    
    // Método para buscar un producto por ID
    public Producto buscarProductoPorId(int idProducto) {
        Producto producto = null;
        String sql = "SELECT * FROM producto WHERE idProducto = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            // Establecer el ID del producto en la consulta
            ps.setInt(1, idProducto);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Crear un objeto Producto con los datos obtenidos
                    producto = crearProductoDesdeResultSet(rs);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar el producto por ID: " + ex.getMessage());
        }

        return producto;
    }
    // Método para listar todos los productos ordenados por tipo
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

}
    
    


