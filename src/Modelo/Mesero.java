/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author Roma
 */
public class Mesero {
    private int idMesero;
    private String nombre;
    private int dni;
    private String telefono;
    private String email;
    private LocalDate fechaRegistro;
    private String turno;
    private String sector;
    private Boolean estado;

    public Mesero() {
    }

    public Mesero(String nombre, int dni, String telefono, String email, LocalDate fechaRegistro, String turno, String sector, Boolean estado) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
        this.turno = turno;
        this.sector = sector;
        this.estado = estado;
    }

    public Mesero(int idMesero, String nombre, int dni, String telefono, String email, LocalDate fechaRegistro, String turno, String sector, Boolean estado) {
        this.idMesero = idMesero;
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
        this.turno = turno;
        this.sector = sector;
        this.estado = estado;
    }

    public int getIdMesero() {
        return idMesero;
    }

    public void setIdMesero(int idMesero) {
        this.idMesero = idMesero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Mesero{" + "idMesero=" + idMesero + ", nombre=" + nombre + ", dni=" + dni + ", telefono=" + telefono + ", email=" + email + ", fechaRegistro=" + fechaRegistro + ", turno=" + turno + ", sector=" + sector + ", estado=" + estado + '}';
    }

    

}
