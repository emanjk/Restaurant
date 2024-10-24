/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDateTime;

/**
 *
 * @author Emanuel
 */


public class Reserva {
    private int idReserva;
    private Mesa mesa; // Relación con la clase Mesa
    private String nombreCliente; // Nombre del cliente que realiza la reserva
    private String telefono; // Teléfono del cliente
    private int comensales; // Cantidad de personas para la reserva
    private String sector; // Sector donde se realiza la reserva
    private LocalDateTime fechaHora;
    private boolean estado; 


    // Constructor vacío
    public Reserva() {
    }

    public Reserva(Mesa mesa, String nombreCliente, String telefono, int comensales, String sector, LocalDateTime fechaHora, boolean estado) {
        this.mesa = mesa;
        this.nombreCliente = nombreCliente;
        this.telefono = telefono;
        this.comensales = comensales;
        this.sector = sector;
        this.fechaHora = fechaHora;
        this.estado = estado;
    }

    public Reserva(int idReserva, Mesa mesa, String nombreCliente, String telefono, int comensales, String sector, LocalDateTime fechaHora, boolean estado) {
        this.idReserva = idReserva;
        this.mesa = mesa;
        this.nombreCliente = nombreCliente;
        this.telefono = telefono;
        this.comensales = comensales;
        this.sector = sector;
        this.fechaHora = fechaHora;
        this.estado = estado;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getComensales() {
        return comensales;
    }

    public void setComensales(int comensales) {
        this.comensales = comensales;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
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

    // Método toString para mostrar la información de la reserva
    @Override
    public String toString() {
        return "Reserva{" +
                "idReserva=" + idReserva +
                ", fechaHora=" + fechaHora +
                ", mesa=" + (mesa != null ? mesa.getIdMesa() : "Sin asignar") +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", telefono='" + telefono + '\'' +
                ", cantidadPersonas=" + comensales +
                ", sector='" + sector + '\'' +
                ", estado=" + estado +
                '}';
    }
}

