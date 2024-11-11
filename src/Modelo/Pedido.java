package Modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int idPedido;
    private Mesa mesa;
    private Mesero mesero;
    private LocalDateTime fechaHora;
    private boolean estado;
    private List<PedidoProducto> productos; 

    
    
    // Constructor vacío
    public Pedido() {
        this.productos = new ArrayList<>(); // Inicialización de la lista de productos
    }

    public Pedido(Mesa mesa, Mesero mesero, LocalDateTime fechaHora, boolean estado, List<PedidoProducto> productos) {
        this.mesa = mesa;
        this.mesero = mesero;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.productos = productos;
    }

    public Pedido(int idPedido, Mesa mesa, Mesero mesero, LocalDateTime fechaHora, boolean estado, List<PedidoProducto> productos) {
        this.idPedido = idPedido;
        this.mesa = mesa;
        this.mesero = mesero;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.productos = productos;
    }

    public Pedido(int idPedido, Mesa mesa, Mesero mesero, LocalDateTime fechaHora, boolean estado) {
        this.idPedido = idPedido;
        this.mesa = mesa;
        this.mesero = mesero;
        this.fechaHora = fechaHora;
        this.estado = estado;
    }
    
    

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Mesero getMesero() {
        return mesero;
    }

    public void setMesero(Mesero mesero) {
        this.mesero = mesero;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<PedidoProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<PedidoProducto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Pedido{" + 
                "idPedido=" + idPedido + 
                ", mesa=" + mesa + 
                ", mesero=" + mesero + 
                ", fechaHora=" + fechaHora + 
                ", estado=" + (estado ? "Activo" : "Pagado") + 
                ", productos=" + productos + 
                '}';
    }

}
