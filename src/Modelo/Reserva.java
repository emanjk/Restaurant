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
    private LocalDateTime fechaHora;
    private Mesa mesa; // Relación con la clase Mesa
    private String nombreCliente; // Nombre del cliente que realiza la reserva
    private int cantidadPersonas; // Cantidad de personas para la reserva

    // Constructor vacío
    public Reserva() {
    }

    // Constructor con parámetros sin idReserva
    public Reserva(LocalDateTime fechaHora, Mesa mesa, String nombreCliente, int cantidadPersonas) {
        this.fechaHora = fechaHora;
        this.mesa = mesa;
        this.nombreCliente = nombreCliente;
        this.cantidadPersonas = cantidadPersonas;
    }

    // Constructor con todos los parámetros
    public Reserva(int idReserva, LocalDateTime fechaHora, Mesa mesa, String nombreCliente, int cantidadPersonas) {
        this.idReserva = idReserva;
        this.fechaHora = fechaHora;
        this.mesa = mesa;
        this.nombreCliente = nombreCliente;
        this.cantidadPersonas = cantidadPersonas;
    }

    // Getters y Setters
    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
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

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    // Métodos adicionales para la clase Reserva

    // Método para confirmar la reserva
    public void confirmarReserva() {
        System.out.println("La reserva para " + nombreCliente + " ha sido confirmada en la mesa " + mesa.getIdMesa() + " para " + cantidadPersonas + " personas.");
    }

    // Método para cancelar la reserva
    public void cancelarReserva() {
        System.out.println("La reserva para " + nombreCliente + " ha sido cancelada.");
        this.mesa = null; // Liberar la mesa asociada
    }

    // Método para verificar si la reserva está activa
    public boolean esActiva() {
        return LocalDateTime.now().isBefore(fechaHora);
    }

    // Método para cambiar la fecha y hora de la reserva
    public void cambiarFechaHora(LocalDateTime nuevaFechaHora) {
        this.fechaHora = nuevaFechaHora;
        System.out.println("La fecha y hora de la reserva ha sido cambiada a: " + nuevaFechaHora);
    }

    // Método para cambiar la mesa de la reserva
    public void cambiarMesa(Mesa nuevaMesa) {
        this.mesa = nuevaMesa;
        System.out.println("La mesa de la reserva ha sido cambiada a la mesa número: " + nuevaMesa.getIdMesa());
    }

    // Método toString para mostrar la información de la reserva
    @Override
    public String toString() {
        return "Reserva{" +
                "idReserva=" + idReserva +
                ", fechaHora=" + fechaHora +
                ", mesa=" + (mesa != null ? mesa.getIdMesa() : "Sin asignar") +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", cantidadPersonas=" + cantidadPersonas +
                '}';
    }
}

