/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author Emanuel
 */


public class ProductoData {

    private Connection con; // Conexión a la base de datos

    // Constructor que recibe la conexión
    public ProductoData(Connection connection) {
        this.con = connection; // Asigna la conexión proporcionada
    }

    // Método para dar de alta un producto (INSERT)
    public void altaProducto(Producto producto) {
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

    // Método para dar de baja un producto de manera lógica (UPDATE)
    public void bajaProducto(int idProducto) {
        String sql = "UPDATE producto SET estado = false WHERE idProducto = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idProducto);

            int resultado = ps.executeUpdate();
            if (resultado == 1) {
                System.out.println("Producto dado de baja lógicamente.");
            } else {
                System.out.println("No se encontró el producto con ID: " + idProducto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de baja el producto: " + ex.getMessage());
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
}
    
    


