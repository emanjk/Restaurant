
package Modelo;


public class Mesa {
    //atributo
    private int idMesa;
    private int capacidad;
    private boolean estado;
    private String sector;
    
  //constructores
    public Mesa() {
    }

    public Mesa(int idMesa, int capacidad, boolean estado, String sector) {
        this.idMesa = idMesa;
        this.capacidad = capacidad;
        this.estado = estado;
        this.sector =sector;
    }

    public Mesa(int capacidad, boolean estado, String sector) {
        this.capacidad = capacidad;
        this.estado = estado;
        this.sector = sector;
    }

    //metodos getters
    public int getIdMesa() {
        return idMesa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public String getSector() {
        return sector;
    }

    
    //metodos setters
    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    
    
    @Override
    public String toString() {
        return idMesa +" " + capacidad + " " + estado+" "+ sector;
    }
    
    
    
}
