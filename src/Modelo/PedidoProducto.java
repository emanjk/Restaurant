
package Modelo;


public class PedidoProducto {
   
    private int idPedidoProducto; // ID único para la tabla intermedia (opcional)
    private Pedido pedido; // Relación con Pedido
    private Producto producto; // Relación con Producto
    private int cantidad; // Cantidad de productos en el pedido
    private double subtotal; // Precio total por el producto en el pedido
    private boolean estado;

    // Constructor vacío
    public PedidoProducto() {
    }

    public PedidoProducto(Pedido pedido, Producto producto, int cantidad, double subtotal, boolean estado) {
        this.pedido = pedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.estado = estado;
    }

    public PedidoProducto(int idPedidoProducto, Pedido pedido, Producto producto, int cantidad, double subtotal, boolean estado) {
        this.idPedidoProducto = idPedidoProducto;
        this.pedido = pedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.estado = estado;
    }

    public int getIdPedidoProducto() {
        return idPedidoProducto;
    }

    public void setIdPedidoProducto(int idPedidoProducto) {
        this.idPedidoProducto = idPedidoProducto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "PedidoProducto{" + 
                "idPedidoProducto=" + idPedidoProducto + 
                ", pedido=" + pedido.getIdPedido() + 
                ", producto=" + producto.getIdProducto() + 
                ", cantidad=" + cantidad + 
                ", subtotal=" + subtotal + 
                ", estado=" + (estado ? "Sumado" : "Restado");
    }
}


