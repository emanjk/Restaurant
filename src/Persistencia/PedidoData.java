
package Persistencia;
import Modelo.Pedido;
import Modelo.Mesa;
import Modelo.Mesero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class PedidoData {
  
    private Connection con; // Conexión a la base de datos

    // Constructor que recibe la conexión
    public PedidoData(Connection connection) {
        this.con = connection; // Asigna la conexión proporcionada
    }

    // 1. Método para crear un nuevo pedido
    public void crearPedido(Pedido pedido) {
        String sql = "INSERT INTO pedido (idMesa, idMesero, fechaHora, estado) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
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
            System.out.println("Pedido creado con éxito.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear el pedido: " + ex.getMessage());
        }
    }

    // 3. Método para buscar un pedido por ID
    public Pedido buscarPedidoPorId(int idPedido) {
        Pedido pedido = null;
        String sql = "SELECT * FROM pedido WHERE idPedido = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPedido);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Mesa mesa = new MesaData(con).buscarMesa(rs.getInt("idMesa"));
                Mesero mesero = new MeseroData(con).buscarMeseroPorId(rs.getInt("idMesero"));
                LocalDateTime fechaHora = rs.getTimestamp("fechaHora").toLocalDateTime();
                boolean estado = rs.getBoolean("estado");


                // Crear el objeto Pedido con los datos obtenidos
                pedido = new Pedido(idPedido, mesa, mesero, fechaHora, estado);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar el pedido: " + ex.getMessage());
        }

        return pedido;
    }
    
    // 5. Método para modificar un pedido
    public void modificarPedido(Pedido pedido) {
        String sql = "UPDATE pedido SET idMesa = ?, idMesero = ?, fechaHora = ?, estado = ? WHERE idPedido = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, pedido.getMesa().getIdMesa());
            ps.setInt(2, pedido.getMesero().getIdMesero());
            ps.setTimestamp(3, Timestamp.valueOf(pedido.getFechaHora()));
            ps.setBoolean(4, pedido.isEstado());
            ps.setInt(5, pedido.getIdPedido());

            int exito = ps.executeUpdate();
            if (exito == 1) {
                System.out.println("Pedido modificado con éxito.");
            } else {
                System.out.println("No se encontró el pedido con ID: " + pedido.getIdPedido());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar el pedido: " + ex.getMessage());
        }
    }

    // 7. Método para eliminar un pedido (baja lógica)
    public void eliminarPedido(int idPedido) {
        String sql = "UPDATE pedido SET estado = false WHERE idPedido = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
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
    
    // 8. Método para buscar pedidos por mesa
    public List<Pedido> buscarPedidosPorMesa(int idMesa) {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedido WHERE idMesa = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            // Establecer el ID de la mesa en la consulta
            ps.setInt(1, idMesa);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    // Obtener el ID del pedido
                    int idPedido = rs.getInt("idPedido");

                    // Obtener la mesa por ID
                    Mesa mesa = new MesaData(con).buscarMesa(rs.getInt("idMesa"));

                    // Obtener el mesero por ID
                    int idMesero = rs.getInt("idMesero");
                    Mesero mesero = new MeseroData(con).buscarMeseroPorId(idMesero);

                    // Obtener fecha y hora
                    LocalDateTime fechaHora = rs.getTimestamp("fechaHora").toLocalDateTime();

                    // Obtener el estado del pedido
                    boolean estado = rs.getBoolean("estado");
                    
                    // Crear un nuevo objeto Pedido con los datos obtenidos
                    Pedido pedido = new Pedido(idPedido, mesa, mesero, fechaHora, estado);

                    // Agregar el pedido a la lista
                    pedidos.add(pedido);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar los pedidos por mesa: " + ex.getMessage());
        }

        return pedidos;
    }
    
    // 9. Método para buscar pedidos por mesero
    public List<Pedido> buscarPedidosPorMesero(int idMesero) {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedido WHERE idMesero = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            // Establecer el ID del mesero en la consulta
            ps.setInt(1, idMesero);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    // Obtener el ID del pedido
                    int idPedido = rs.getInt("idPedido");

                    // Obtener la mesa por ID
                    Mesa mesa = new MesaData(con).buscarMesa(rs.getInt("idMesa"));

                    // Obtener el mesero por ID
                    Mesero mesero = new MeseroData(con).buscarMeseroPorId(idMesero);

                    // Obtener fecha y hora
                    LocalDateTime fechaHora = rs.getTimestamp("fechaHora").toLocalDateTime();

                    // Obtener el estado del pedido
                    boolean estado = rs.getBoolean("estado");

                    // Crear un nuevo objeto Pedido con los datos obtenidos
                    Pedido pedido = new Pedido(idPedido, mesa, mesero, fechaHora, estado);

                    // Agregar el pedido a la lista
                    pedidos.add(pedido);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar los pedidos por mesero: " + ex.getMessage());
        }

        return pedidos;
    }
    
    // 10. Método para obtener todos los pedidos
    public List<Pedido> listarPedidos() {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedido";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                // Obtener el ID del pedido
                int idPedido = rs.getInt("idPedido");

                // Obtener la mesa por ID
                Mesa mesa = new MesaData(con).buscarMesa(rs.getInt("idMesa"));

                // Obtener el mesero por ID
                int idMesero = rs.getInt("idMesero");
                Mesero mesero = new MeseroData(con).buscarMeseroPorId(idMesero);

                // Obtener fecha y hora
                LocalDateTime fechaHora = rs.getTimestamp("fechaHora").toLocalDateTime();

                // Obtener el estado del pedido
                boolean estado = rs.getBoolean("estado");

                // Crear un nuevo objeto Pedido con los datos obtenidos
                Pedido pedido = new Pedido(idPedido, mesa, mesero, fechaHora, estado);

                // Agregar el pedido a la lista
                pedidos.add(pedido);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener todos los pedidos: " + ex.getMessage());
        }

        return pedidos;
    }
    
    // 11. Método para buscar pedidos por fecha
    public List<Pedido> buscarPedidosPorFecha(LocalDate fecha) {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedido WHERE DATE(fechaHora) = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            // Convertir LocalDate a java.sql.Date para la consulta SQL
            ps.setDate(1, java.sql.Date.valueOf(fecha));

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    // Obtener el ID del pedido
                    int idPedido = rs.getInt("idPedido");

                    // Obtener la mesa por ID
                    Mesa mesa = new MesaData(con).buscarMesa(rs.getInt("idMesa"));

                    // Obtener el mesero por ID
                    int idMesero = rs.getInt("idMesero");
                    Mesero mesero = new MeseroData(con).buscarMeseroPorId(idMesero);

                    // Obtener fecha y hora
                    LocalDateTime fechaHora = rs.getTimestamp("fechaHora").toLocalDateTime();

                    // Obtener el estado del pedido
                    boolean estado = rs.getBoolean("estado");

                    // Crear un nuevo objeto Pedido con los datos obtenidos
                    Pedido pedido = new Pedido(idPedido, mesa, mesero, fechaHora, estado);

                    // Agregar el pedido a la lista
                    pedidos.add(pedido);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar los pedidos por fecha: " + ex.getMessage());
        }

        return pedidos;
    }

    public List<Pedido> buscarPedidosPorRangoDeFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedido WHERE DATE(fechaHora) BETWEEN ? AND ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            // Convertir LocalDate a java.sql.Date para la consulta SQL
            ps.setDate(1, java.sql.Date.valueOf(fechaInicio));
            ps.setDate(2, java.sql.Date.valueOf(fechaFin));

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int idPedido = rs.getInt("idPedido");
                    Mesa mesa = new MesaData(con).buscarMesa(rs.getInt("idMesa"));
                    int idMesero = rs.getInt("idMesero");
                    Mesero mesero = new MeseroData(con).buscarMeseroPorId(idMesero);
                    LocalDateTime fechaHora = rs.getTimestamp("fechaHora").toLocalDateTime();
                    boolean estado = rs.getBoolean("estado");
                    Pedido pedido = new Pedido(idPedido, mesa, mesero, fechaHora, estado);
                    pedidos.add(pedido);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar los pedidos por rango de fechas: " + ex.getMessage());
        }

        return pedidos;
    }

    public List<Pedido> buscarPedidosPorEstado(boolean estado) {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedido WHERE estado = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setBoolean(1, estado); // `true` para activos, `false` para completados

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    // Obtener el ID del pedido
                    int idPedido = rs.getInt("idPedido");

                    // Obtener la mesa por ID
                    Mesa mesa = new MesaData(con).buscarMesa(rs.getInt("idMesa"));

                    // Obtener el mesero por ID
                    int idMesero = rs.getInt("idMesero");
                    Mesero mesero = new MeseroData(con).buscarMeseroPorId(idMesero);

                    // Obtener fecha y hora
                    LocalDateTime fechaHora = rs.getTimestamp("fechaHora").toLocalDateTime();

                    // Crear un nuevo objeto Pedido con los datos obtenidos
                    Pedido pedido = new Pedido(idPedido, mesa, mesero, fechaHora, estado);

                    // Agregar el pedido a la lista
                    pedidos.add(pedido);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar los pedidos por estado: " + ex.getMessage());
        }

        return pedidos;
    }

    public List<Pedido> obtenerPedidosPorSector(String sector) {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT p.* FROM pedido p " +
                     "JOIN mesa m ON p.idMesa = m.idMesa " +
                     "WHERE m.sector = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, sector);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idPedido = rs.getInt("idPedido");
                Mesa mesa = new MesaData(con).buscarMesa(rs.getInt("idMesa"));
                Mesero mesero = new MeseroData(con).buscarMeseroPorId(rs.getInt("idMesero"));
                LocalDateTime fechaHora = rs.getTimestamp("fechaHora").toLocalDateTime();
                boolean estado = rs.getBoolean("estado");

                Pedido pedido = new Pedido(idPedido, mesa, mesero, fechaHora, estado);
                pedidos.add(pedido);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener los pedidos por sector: " + ex.getMessage());
        }

        return pedidos;
    }
}

