/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;
import Modelo.Pedido;
import Modelo.Producto;
import Modelo.Mesa;
import Modelo.Mesero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Roma
 */
public class PedidoData {
  
    private Connection connection;

    // Constructor que recibe la conexión
    public PedidoData(Connection connection) {
        this.connection = connection;
    }

    // Método para crear un nuevo pedido
    public void crearPedido(Pedido pedido) {
        String sql = "INSERT INTO pedido (idMesa, idMesero, fechaHora, estado) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, pedido.getMesa().getIdMesa());
            ps.setInt(2, pedido.getMesero().getIdMesero());
            ps.setTimestamp(3, Timestamp.valueOf(pedido.getFechaHora()));
            ps.setBoolean(4, pedido.isEstado());

            ps.executeUpdate();

            // Obtener el ID generado para el pedido
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pedido.setIdPedido(rs.getInt(1));
            }

            // Guardar los productos del pedido
            guardarProductosDelPedido(pedido);

            System.out.println("Pedido creado con éxito.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear el pedido: " + ex.getMessage());
        }
    }

    // Método para guardar los productos de un pedido en la tabla intermedia
    private void guardarProductosDelPedido(Pedido pedido) {
        String sql = "INSERT INTO pedidoproducto (idPedido, idProducto, cantidad, precioTotal) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            for (Producto producto : pedido.getProductos()) {
                ps.setInt(1, pedido.getIdPedido());
                ps.setInt(2, producto.getIdProducto());
                ps.setInt(3, producto.getStock()); // Se asume que 'stock' representa la cantidad pedida
                ps.setDouble(4, producto.getPrecio() * producto.getStock());

                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar los productos del pedido: " + ex.getMessage());
        }
    }

    // Método para buscar un pedido por ID
    public Pedido buscarPedido(int idPedido) {
        Pedido pedido = null;
        String sql = "SELECT * FROM pedido WHERE idPedido = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idPedido);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Mesa mesa = new MesaData(connection).buscarMesa(rs.getInt("idMesa"));
                Mesero mesero = new MeseroData(connection).buscarMesero(rs.getInt("idMesero"));
                LocalDateTime fechaHora = rs.getTimestamp("fechaHora").toLocalDateTime();
                boolean estado = rs.getBoolean("estado");

                pedido = new Pedido(idPedido, mesa, mesero, fechaHora, estado, obtenerProductosPorPedido(idPedido));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar el pedido: " + ex.getMessage());
        }

        return pedido;
    }

    // Método para obtener los productos de un pedido específico
    private List<Producto> obtenerProductosPorPedido(int idPedido) {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT p.* FROM producto p " +
                     "JOIN pedidoproducto pp ON p.idProducto = pp.idProducto " +
                     "WHERE pp.idPedido = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idPedido);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto(
                    rs.getInt("idProducto"),
                    rs.getInt("codigo"),
                    rs.getString("nombre"),
                    rs.getString("tipo"),
                    rs.getString("descripcion"),
                    rs.getDouble("precio"),
                    rs.getInt("stock"),
                    rs.getBoolean("estado")
                );
                productos.add(producto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener los productos del pedido: " + ex.getMessage());
        }

        return productos;
    }

    // Método para modificar un pedido
    public void modificarPedido(Pedido pedido) {
        String sql = "UPDATE pedido SET idMesa = ?, idMesero = ?, fechaHora = ?, estado = ? WHERE idPedido = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, pedido.getMesa().getIdMesa());
            ps.setInt(2, pedido.getMesero().getIdMesero());
            ps.setTimestamp(3, Timestamp.valueOf(pedido.getFechaHora()));
            ps.setBoolean(4, pedido.isEstado());
            ps.setInt(5, pedido.getIdPedido());

            int exito = ps.executeUpdate();
            if (exito == 1) {
                // Modificar los productos del pedido
                eliminarProductosDelPedido(pedido.getIdPedido());
                guardarProductosDelPedido(pedido);

                System.out.println("Pedido modificado con éxito.");
            } else {
                System.out.println("No se encontró el pedido con ID: " + pedido.getIdPedido());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar el pedido: " + ex.getMessage());
        }
    }

    // Método para eliminar los productos de un pedido antes de actualizarlos
    private void eliminarProductosDelPedido(int idPedido) {
        String sql = "DELETE FROM pedidoproducto WHERE idPedido = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idPedido);
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar productos del pedido: " + ex.getMessage());
        }
    }

    // Método para eliminar un pedido (baja lógica)
    public void eliminarPedido(int idPedido) {
        String sql = "UPDATE pedido SET estado = false WHERE idPedido = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idPedido);

            int exito = ps.executeUpdate();
            if (exito == 1) {
                System.out.println("Pedido eliminado (baja lógica) con éxito.");
            } else {
                System.out.println("No se encontró el pedido con ID: " + idPedido);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el pedido: " + ex.getMessage());
        }
    }
}

