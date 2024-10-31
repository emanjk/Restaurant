
package Persistencia;
import Modelo.Pedido;
import Modelo.Producto;
import Modelo.PedidoProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
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
    
    // Método para actualizar un PedidoProducto
    public void actualizarPedidoProducto(PedidoProducto pedidoProducto) {
        String sql = "UPDATE pedidoproducto SET cantidad = ?, subtotal = ? WHERE idPedidoProducto = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, pedidoProducto.getCantidad());
            ps.setDouble(2, pedidoProducto.getSubtotal());
            ps.setInt(3, pedidoProducto.getIdPedidoProducto());

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("PedidoProducto actualizado exitosamente.");
            } else {
                System.out.println("No se encontró el PedidoProducto con ID: " + pedidoProducto.getIdPedidoProducto());
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar PedidoProducto: " + e.getMessage());
        }
    }
    
    // Método para obtener las ganancias entre dos fechas
    public double obtenerGananciasEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        double ganancias = 0.0;
        String sql = "SELECT SUM(pp.subtotal) AS totalGanancias " +
                     "FROM pedidoproducto pp " +
                     "JOIN pedido p ON pp.idPedido = p.idPedido " +
                     "WHERE DATE(p.fechaHora) BETWEEN ? AND ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            // Convertir LocalDate a java.sql.Date para la consulta SQL
            ps.setDate(1, java.sql.Date.valueOf(fechaInicio));
            ps.setDate(2, java.sql.Date.valueOf(fechaFin));

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ganancias = rs.getDouble("totalGanancias");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al calcular las ganancias entre fechas: " + ex.getMessage());
        }

        return ganancias;
    }
        public double obtenerGananciasEntreHoras(LocalTime horaInicio, LocalTime horaFin) {
        double ganancias = 0.0;
        String sql = "SELECT SUM(pp.subtotal) AS totalGanancias " +
                     "FROM pedidoproducto pp " +
                     "JOIN pedido p ON pp.idPedido = p.idPedido " +
                     "WHERE TIME(p.fechaHora) BETWEEN ? AND ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            // Convertir LocalTime a java.sql.Time para la consulta SQL
            ps.setTime(1, java.sql.Time.valueOf(horaInicio));
            ps.setTime(2, java.sql.Time.valueOf(horaFin));

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ganancias = rs.getDouble("totalGanancias");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al calcular las ganancias entre horas: " + ex.getMessage());
        }

        return ganancias;
    }
    
    public double obtenerGananciasPorSector(String sector) {
        double ganancias = 0.0;
        String sql = "SELECT SUM(pp.subtotal) AS totalGanancias " +
                     "FROM pedidoproducto pp " +
                     "JOIN pedido p ON pp.idPedido = p.idPedido " +
                     "JOIN mesa m ON p.idMesa = m.idMesa " +
                     "WHERE m.sector = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, sector);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ganancias = rs.getDouble("totalGanancias");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al calcular las ganancias por sector: " + ex.getMessage());
        }

        return ganancias;
    }
        
    public double obtenerGananciasPorMesero(int idMesero) {
        double ganancias = 0.0;
        String sql = "SELECT SUM(pp.subtotal) AS totalGanancias " +
                     "FROM pedidoproducto pp " +
                     "JOIN pedido p ON pp.idPedido = p.idPedido " +
                     "WHERE p.idMesero = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idMesero);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ganancias = rs.getDouble("totalGanancias");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al calcular las ganancias por mesero: " + ex.getMessage());
        }

        return ganancias;
    }

    
    // Método para buscar un producto específico en un pedido
    public PedidoProducto buscarProductoEnPedido(int idPedido, int idProducto) {
        PedidoProducto pedidoProducto = null;
        String sql = "SELECT * FROM pedidoproducto WHERE idPedido = ? AND idProducto = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPedido);
            ps.setInt(2, idProducto);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pedidoProducto = new PedidoProducto();
                pedidoProducto.setIdPedidoProducto(rs.getInt("idPedidoProducto"));

                // Buscar el pedido asociado
                Pedido pedido = new PedidoData(con).buscarPedido(idPedido);
                pedidoProducto.setPedido(pedido);

                // Buscar el producto asociado
                Producto producto = new ProductoData(con).buscarProductoPorId(idProducto);
                pedidoProducto.setProducto(producto);

                pedidoProducto.setCantidad(rs.getInt("cantidad"));
                pedidoProducto.setSubtotal(rs.getDouble("subtotal"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar el producto en el pedido: " + e.getMessage());
        }
        return pedidoProducto;
    }



}

