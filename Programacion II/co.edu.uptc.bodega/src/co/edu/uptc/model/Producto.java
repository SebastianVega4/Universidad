package co.edu.uptc.model;

public class Producto {
    private String cod;
    private String nombre;
    private float precio ;

    public Producto(String cod, String nombre, float precio) {
        this.cod = cod;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
