/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;
import Modelo.Pedido;
import Modelo.Producto;
import Modelo.PedidoProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Roma
 */
public class PedidoProductoData {

   private Connection con; // Conexión a la base de datos

    // Constructor que recibe la conexión
    public PedidoProductoData(Connection connection) {
        this.con = connection; // Asigna la conexión proporcionada
    }

    // Método para agregar un PedidoProducto
    public void agregarPedidoProducto(PedidoProducto pedidoProducto) {
        String sql = "INSERT INTO pedidoproducto (idPedido, idProducto, cantidad, subotal) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, pedidoProducto.getPedido().getIdPedido());
            ps.setInt(2, pedidoProducto.getProducto().getIdProducto());
            ps.setInt(3, pedidoProducto.getCantidad());
            ps.setDouble(4, pedidoProducto.getSubtotal());

            ps.executeUpdate();
            System.out.println("PedidoProducto agregado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al agregar PedidoProducto: " + e.getMessage());
        }
    }

    // Método para obtener todos los PedidoProducto de un pedido específico
    public List<PedidoProducto> obtenerProductosPorPedido(Pedido pedido) {
        String sql = "SELECT * FROM pedidoproducto WHERE idPedido = ?";
        List<PedidoProducto> lista = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, pedido.getIdPedido());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PedidoProducto pedidoProducto = new PedidoProducto();
                pedidoProducto.setIdPedidoProducto(rs.getInt("idPedidoProducto"));
                pedidoProducto.setPedido(pedido);

                
                String nombre = rs.getString("Nombre");
                Producto producto = (Producto) new ProductoData(con).buscarProductoPorNombre(nombre);

                pedidoProducto.setProducto(producto);
                pedidoProducto.setCantidad(rs.getInt("cantidad"));
                pedidoProducto.setSubtotal(rs.getDouble("precioTotal"));

                lista.add(pedidoProducto);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener productos del pedido: " + e.getMessage());
        }
        return lista;
    }
}

