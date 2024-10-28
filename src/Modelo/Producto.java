
package Modelo;

public class Producto implements Comparable<Producto>{
    private int idProducto;
    private int codigo; 
    private String nombre;
    private String tipo;
    private String descripcion;
    private double precio;
    private int stock;
    private boolean estado;

    // Constructor vacío
    public Producto() {
    }

    // Constructor sin idProducto
    public Producto(int codigo, String nombre, String tipo, String descripcion, double precio, int stock, boolean estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
    }

    // Constructor con idProducto
    public Producto(int idProducto, int codigo, String nombre, String tipo, String descripcion, double precio, int stock, boolean estado) {
        this.idProducto = idProducto;
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
    }

    // Getters y Setters
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCodigo() { 
        return codigo;
    }

    public void setCodigo(int codigo) { 
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    // Método toString 
    @Override
   public String toString() {
        return "Producto:\n" + 
               "ID: " + idProducto + "\n" + 
               "Codigo: " + codigo + "\n" + 
               "Nombre: " + nombre + "\n" + 
               "Tipo: " + tipo + "\n" + 
               "Descripcion: " + descripcion + "\n" + 
               "Precio: " + precio + "\n" + 
               "Stock: " + stock + "\n" + 
               "Estado: " + (estado ? "Inactivo" : "Agotado") + 
               "\n\n";
   }

    @Override
    public int compareTo(Producto o) {
        if(codigo == o.codigo){
            return 0;
        }else if(codigo > o.codigo){
            return 1;
        }else{
            return -1;
        }
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idProducto;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (this.idProducto!= other.idProducto){
            return false;
        }
        return true;
    }
}
    
    
    
    
    
    

