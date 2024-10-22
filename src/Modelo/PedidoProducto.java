/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Roma
 */
public class PedidoProducto {
   
    private int idPedidoProducto; // ID único para la tabla intermedia (opcional)
    private Pedido pedido; // Relación con Pedido
    private Producto producto; // Relación con Producto
    private int cantidad; // Cantidad de productos en el pedido
    private double subtotal; // Precio total por el producto en el pedido

    // Constructor vacío
    public PedidoProducto() {
    }

    // Constructor con parámetros
    public PedidoProducto(Pedido pedido, Producto producto, int cantidad, double subtotal) {
        this.pedido = pedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    // Constructor con ID
    public PedidoProducto(int idPedidoProducto, Pedido pedido, Producto producto, int cantidad, double precioTotal) {
        this.idPedidoProducto = idPedidoProducto;
        this.pedido = pedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    // Getters y Setters
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

    @Override
    public String toString() {
        return "PedidoProducto{" +
                "idPedidoProducto=" + idPedidoProducto +
                ", pedido=" + pedido.getIdPedido() +
                ", producto=" + producto.getIdProducto() +
                ", cantidad=" + cantidad +
                ", precioTotal=" + subtotal +
                '}';
    }
}


