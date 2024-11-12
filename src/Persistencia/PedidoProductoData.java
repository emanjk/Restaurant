
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
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    
    
    /// 1. Agregar un PedidoProducto y actualizar el stock
    public void agregarPedidoProducto(PedidoProducto pedidoProducto) {
        String sqlInsert = "INSERT INTO pedidoproducto (idPedido, idProducto, cantidad, subtotal, estado) VALUES (?, ?, ?, ?, ?)";
        String sqlUpdateStock = "UPDATE producto SET stock = stock - ? WHERE idProducto = ?";

        try {
            // Iniciar la transacción
            con.setAutoCommit(false);

            // Agregar el PedidoProducto
            try (PreparedStatement psInsert = con.prepareStatement(sqlInsert)) {
                psInsert.setInt(1, pedidoProducto.getPedido().getIdPedido());
                psInsert.setInt(2, pedidoProducto.getProducto().getIdProducto());
                psInsert.setInt(3, pedidoProducto.getCantidad());
                psInsert.setDouble(4, pedidoProducto.getSubtotal());
                psInsert.setBoolean(5, pedidoProducto.isEstado());

                psInsert.executeUpdate();
                System.out.println("PedidoProducto agregado exitosamente.");
            }

            // Actualizar el stock del producto
            try (PreparedStatement psUpdateStock = con.prepareStatement(sqlUpdateStock)) {
                psUpdateStock.setInt(1, pedidoProducto.getCantidad()); // Cantidad a restar del stock
                psUpdateStock.setInt(2, pedidoProducto.getProducto().getIdProducto());

                psUpdateStock.executeUpdate();
                System.out.println("Stock actualizado exitosamente.");
            }

            // Confirmar la transacción
            con.commit();
        } catch (SQLException e) {
            try {
                // Revertir la transacción en caso de error
                con.rollback();
                System.out.println("Transacción revertida. Error al agregar PedidoProducto y actualizar stock: " + e.getMessage());
            } catch (SQLException rollbackEx) {
                System.out.println("Error al intentar revertir la transacción: " + rollbackEx.getMessage());
            }
        } finally {
            try {
                // Restaurar el modo de autocommit
                con.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("Error al restaurar el modo de autocommit: " + e.getMessage());
            }
        }
    }


    // 2. Obtener todos los PedidoProducto
    public List<PedidoProducto> obtenerPedidosProductos() {
        List<PedidoProducto> lista = new ArrayList<>();
        String sql = "SELECT * FROM pedidoproducto";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // Crear un nuevo PedidoProducto y asignar sus valores desde la base de datos
                PedidoProducto pedidoProducto = new PedidoProducto();
                pedidoProducto.setIdPedidoProducto(rs.getInt("idPedidoProducto"));

                // Cargar el pedido asociado
                Pedido pedido = new PedidoData(con).buscarPedidoPorId(rs.getInt("idPedido"));
                pedidoProducto.setPedido(pedido);

                // Cargar el producto asociado
                Producto producto = new ProductoData(con).buscarProductoPorId(rs.getInt("idProducto"));
                pedidoProducto.setProducto(producto);

                // Asignar otros campos
                pedidoProducto.setCantidad(rs.getInt("cantidad"));
                pedidoProducto.setSubtotal(rs.getDouble("subtotal"));
                pedidoProducto.setEstado(rs.getBoolean("estado"));

                // Añadir a la lista
                lista.add(pedidoProducto);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener todos los PedidoProducto: " + e.getMessage());
        }
        return lista;
    }


    // 3 obtener todos los PedidoProducto de un pedido específico
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

                int idProducto = rs.getInt("idProducto");
                Producto producto = new ProductoData(con).buscarProductoPorId(idProducto);

                pedidoProducto.setProducto(producto);
                pedidoProducto.setCantidad(rs.getInt("cantidad"));
                pedidoProducto.setSubtotal(rs.getDouble("subtotal"));
                pedidoProducto.setEstado(rs.getBoolean("estado"));

                lista.add(pedidoProducto);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener productos del pedido: " + e.getMessage());
        }
        return lista;
    }
    
    // 4. Método para actualizar un PedidoProducto
    public void actualizarPedidoProducto(PedidoProducto pedidoProducto) {
        String sql = "UPDATE pedidoproducto SET cantidad = ?, subtotal = ?, estado = ? WHERE idPedidoProducto = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, pedidoProducto.getCantidad());
            ps.setDouble(2, pedidoProducto.getSubtotal());
            ps.setBoolean(3, pedidoProducto.isEstado());
            ps.setInt(4, pedidoProducto.getIdPedidoProducto());

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
    
    //5.
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

                Pedido pedido = new PedidoData(con).buscarPedidoPorId(idPedido);
                pedidoProducto.setPedido(pedido);

                Producto producto = new ProductoData(con).buscarProductoPorId(idProducto);
                pedidoProducto.setProducto(producto);

                pedidoProducto.setCantidad(rs.getInt("cantidad"));
                pedidoProducto.setSubtotal(rs.getDouble("subtotal"));
                pedidoProducto.setEstado(rs.getBoolean("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar el producto en el pedido: " + e.getMessage());
        }
        return pedidoProducto;
    }
    
    // 6. Método para obtener las ganancias entre dos fechas
    public double obtenerGananciasEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        double ganancias = 0.0;
        String sql = "SELECT SUM(pp.subtotal) AS totalGanancias " +
                     "FROM pedidoproducto pp " +
                     "JOIN pedido p ON pp.idPedido = p.idPedido " +
                     "WHERE DATE(p.fechaHora) BETWEEN ? AND ? AND pp.estado = true";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
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

    // 7. Obtener ganancias entre dos horas
    public double obtenerGananciasEntreHoras(LocalTime horaInicio, LocalTime horaFin) {
        double ganancias = 0.0;
        String sql = "SELECT SUM(pp.subtotal) AS totalGanancias " +
                     "FROM pedidoproducto pp " +
                     "JOIN pedido p ON pp.idPedido = p.idPedido " +
                     "WHERE TIME(p.fechaHora) BETWEEN ? AND ? AND pp.estado = true";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
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

    // 8. Obtener ganacias por Sector
    public double obtenerGananciasPorSector(String sector) {
        double ganancias = 0.0;
        String sql = "SELECT SUM(pp.subtotal) AS totalGanancias " +
                     "FROM pedidoproducto pp " +
                     "JOIN pedido p ON pp.idPedido = p.idPedido " +
                     "JOIN mesa m ON p.idMesa = m.idMesa " +
                     "WHERE m.sector = ? AND pp.estado = true";

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
        
    // 9. Obtener ganancias por Mesero
    public double obtenerGananciasPorMesero(int idMesero) {
        double ganancias = 0.0;
        String sql = "SELECT SUM(pp.subtotal) AS totalGanancias " +
                     "FROM pedidoproducto pp " +
                     "JOIN pedido p ON pp.idPedido = p.idPedido " +
                     "WHERE p.idMesero = ? AND pp.estado = true";

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

    //10. Obtener ganancias y cantidad vendida por cada producto
    public List<Map<String, Object>> obtenerGananciasPorProducto() {
        List<Map<String, Object>> lista = new ArrayList<>();
        String sql = "SELECT p.nombre AS producto, SUM(pp.cantidad) AS cantidadVendida, SUM(pp.subtotal) AS totalGanancias " +
                     "FROM pedidoproducto pp " +
                     "JOIN producto p ON pp.idProducto = p.idProducto " +
                     "WHERE pp.estado = true " +
                     "GROUP BY p.idProducto";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Map<String, Object> resultado = new HashMap<>();
                resultado.put("producto", rs.getString("producto"));
                resultado.put("cantidadVendida", rs.getInt("cantidadVendida"));
                resultado.put("totalGanancias", rs.getDouble("totalGanancias"));
                lista.add(resultado);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener ganancias por producto: " + e.getMessage());
        }

        return lista;
    }
    
    public List<Map<String, Object>> obtenerGananciasPorProductoEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Map<String, Object>> lista = new ArrayList<>();
        String sql = "SELECT p.nombre AS producto, SUM(pp.cantidad) AS cantidadVendida, SUM(pp.subtotal) AS totalGanancias " +
                     "FROM pedidoproducto pp " +
                     "JOIN producto p ON pp.idProducto = p.idProducto " +
                     "JOIN pedido ped ON pp.idPedido = ped.idPedido " +
                     "WHERE pp.estado = true AND DATE(ped.fechaHora) BETWEEN ? AND ? " +
                     "GROUP BY p.idProducto";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, java.sql.Date.valueOf(fechaInicio));
            ps.setDate(2, java.sql.Date.valueOf(fechaFin));

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Map<String, Object> resultado = new HashMap<>();
                    resultado.put("producto", rs.getString("producto"));
                    resultado.put("cantidadVendida", rs.getInt("cantidadVendida"));
                    resultado.put("totalGanancias", rs.getDouble("totalGanancias"));
                    lista.add(resultado);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener ganancias por producto entre fechas: " + e.getMessage());
        }

        return lista;
    }

    
    // 11. Obtener ganancias entre dos periodos para comparación
    public Map<String, Double> obtenerComparativaGanancias(LocalDate fechaInicio1, LocalDate fechaFin1, LocalDate fechaInicio2, LocalDate fechaFin2) {
        Map<String, Double> comparativaGanancias = new HashMap<>();
        String sql = "SELECT SUM(pp.subtotal) AS totalGanancias " +
                     "FROM pedidoproducto pp " +
                     "JOIN pedido p ON pp.idPedido = p.idPedido " +
                     "WHERE DATE(p.fechaHora) BETWEEN ? AND ? AND pp.estado = true";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            // Primer periodo
            ps.setDate(1, java.sql.Date.valueOf(fechaInicio1));
            ps.setDate(2, java.sql.Date.valueOf(fechaFin1));
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    comparativaGanancias.put("gananciasPeriodo1", rs.getDouble("totalGanancias"));
                }
            }

            // Segundo periodo
            ps.setDate(1, java.sql.Date.valueOf(fechaInicio2));
            ps.setDate(2, java.sql.Date.valueOf(fechaFin2));
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    comparativaGanancias.put("gananciasPeriodo2", rs.getDouble("totalGanancias"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la comparativa de ganancias: " + e.getMessage());
        }

        return comparativaGanancias;
    }

    // 12. Obtener ganancias de un día específico
    public double obtenerGananciasDiarias(LocalDate fecha) {
        double ganancias = 0.0;
        String sql = "SELECT IFNULL(SUM(pp.subtotal), 0) AS totalGanancias " +
                     "FROM pedidoproducto pp " +
                     "JOIN pedido p ON pp.idPedido = p.idPedido " +
                     "WHERE DATE(p.fechaHora) = ? AND pp.estado = true";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, java.sql.Date.valueOf(fecha));

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ganancias = rs.getDouble("totalGanancias");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener ganancias diarias: " + e.getMessage());
        }

        return ganancias;
    }
    
    // 13. Resumen general de ganancias
    public Map<String, Double> obtenerResumenGanancias(LocalDate fechaInicio, LocalDate fechaFin) {
        Map<String, Double> resumen = new HashMap<>();
        resumen.put("gananciasTotales", obtenerGananciasEntreFechas(fechaInicio, fechaFin));
        resumen.put("gananciasComedor", obtenerGananciasPorSector("comedor"));
        resumen.put("gananciasTerraza", obtenerGananciasPorSector("terraza"));
        resumen.put("gananciasPatio", obtenerGananciasPorSector("patio"));

        // Agregar ganancias por cada mesero (idMesero como ejemplo)
        for (int idMesero = 1; idMesero <= 5; idMesero++) { // Ajusta el rango según tu cantidad de meseros
            resumen.put("gananciasMesero" + idMesero, obtenerGananciasPorMesero(idMesero));
        }

        return resumen;
    }

    // En tu método obtenerFechaMasAntigua:
    public LocalDate obtenerFechaMasAntigua() {
        String sql = "SELECT MIN(fechaHora) AS fechaMasAntigua FROM pedido";
        LocalDate fechaMasAntigua = null;

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                java.sql.Date fechaSql = rs.getDate("fechaMasAntigua");
                if (fechaSql != null) {
                    fechaMasAntigua = fechaSql.toLocalDate();  // Conversión directa a LocalDate
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la fecha más antigua: " + e.getMessage());
        }

        return fechaMasAntigua;
    }
    
    private LocalDate convertirASqlDateALocalDate(java.sql.Date fecha) {
        return fecha.toLocalDate();
    }

    
    public double obtenerGananciasTotales() {
        double gananciaTotal = 0.0;
        LocalDate fechaMasAntigua = obtenerFechaMasAntigua();
        LocalDate fechaActual = LocalDate.now();

        if (fechaMasAntigua != null) {
            String sql = "SELECT SUM(pp.subtotal) AS gananciaTotal " +
                         "FROM pedidoproducto pp " +
                         "JOIN pedido p ON pp.idPedido = p.idPedido " +
                         "WHERE DATE(p.fechaHora) BETWEEN ? AND ? AND pp.estado = true";

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setDate(1, java.sql.Date.valueOf(fechaMasAntigua));
                ps.setDate(2, java.sql.Date.valueOf(fechaActual));

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        gananciaTotal = rs.getDouble("gananciaTotal");
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error al calcular la ganancia total: " + e.getMessage());
            }
        }

        return gananciaTotal;
    }
    
    public List<Map<String, Object>> obtenerGananciasPorProductoEnSectorYFechas(String sector, LocalDate fechaInicio, LocalDate fechaFin) {
        List<Map<String, Object>> lista = new ArrayList<>();
        String sql = "SELECT p.nombre AS producto, SUM(pp.cantidad) AS cantidadVendida, SUM(pp.subtotal) AS totalGanancias " +
                     "FROM pedidoproducto pp " +
                     "JOIN producto p ON pp.idProducto = p.idProducto " +
                     "JOIN pedido ped ON pp.idPedido = ped.idPedido " +
                     "JOIN mesa m ON ped.idMesa = m.idMesa " +
                     "WHERE m.sector = ? AND DATE(ped.fechaHora) BETWEEN ? AND ? AND pp.estado = true " +
                     "GROUP BY p.idProducto";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, sector);
            ps.setDate(2, java.sql.Date.valueOf(fechaInicio));
            ps.setDate(3, java.sql.Date.valueOf(fechaFin));

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Map<String, Object> resultado = new HashMap<>();
                    resultado.put("producto", rs.getString("producto"));
                    resultado.put("cantidadVendida", rs.getInt("cantidadVendida"));
                    resultado.put("totalGanancias", rs.getDouble("totalGanancias"));
                    lista.add(resultado);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener ganancias por producto en sector y fechas: " + e.getMessage());
        }

        return lista;
    }

    public List<Map<String, Object>> obtenerGananciasPorProductoEnMeseroYFechas(String meseroNombre, LocalDate fechaInicio, LocalDate fechaFin) {
        List<Map<String, Object>> lista = new ArrayList<>();
        String sql = "SELECT p.nombre AS producto, SUM(pp.cantidad) AS cantidadVendida, SUM(pp.subtotal) AS totalGanancias " +
                     "FROM pedidoproducto pp " +
                     "JOIN producto p ON pp.idProducto = p.idProducto " +
                     "JOIN pedido ped ON pp.idPedido = ped.idPedido " +
                     "JOIN mesero m ON ped.idMesero = m.idMesero " +
                     "WHERE m.nombre = ? AND DATE(ped.fechaHora) BETWEEN ? AND ? AND pp.estado = true " +
                     "GROUP BY p.idProducto";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, meseroNombre);
            ps.setDate(2, java.sql.Date.valueOf(fechaInicio));
            ps.setDate(3, java.sql.Date.valueOf(fechaFin));

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Map<String, Object> resultado = new HashMap<>();
                    resultado.put("producto", rs.getString("producto"));
                    resultado.put("cantidadVendida", rs.getInt("cantidadVendida"));
                    resultado.put("totalGanancias", rs.getDouble("totalGanancias"));
                    lista.add(resultado);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener ganancias por producto en mesero y fechas: " + e.getMessage());
        }

        return lista;
    }



}





