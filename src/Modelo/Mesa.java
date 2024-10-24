
package Modelo;


public class Mesa {
    //atributo
    private int idMesa;
    private int capacidad; //mesa para 2, mesa para 4, mesa para n
    private boolean estado; //(disponible=true, ocupado=false)
    private String sector; // (abajo, arriba, adentro, afuera)
    private String situacion; //estado actual: (libre, ocupada) //chequear opc.
    
  //constructores
    public Mesa() {
    }

    public Mesa(int capacidad, boolean estado, String sector, String situacion) {
        this.capacidad = capacidad;
        this.estado = estado;
        this.sector = sector;
        this.situacion = situacion;
    }

    public Mesa(int idMesa, int capacidad, boolean estado, String sector, String situacion) {
        this.idMesa = idMesa;
        this.capacidad = capacidad;
        this.estado = estado;
        this.sector = sector;
        this.situacion = situacion;
    }

    
    
    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    @Override
    public String toString() {
        return "Mesa{" + "idMesa=" + idMesa + ", capacidad=" + capacidad + ", estado=" + estado + ", sector=" + sector + ", situacion=" + situacion + '}';
    }

    
}