package model;
// Clase abstracta para representar un producto
public abstract class Producto {
    private String nombre;
    private double precioPorOnza;
    private int nivelProducto;
    private int totalVentas;

    public Producto(String nombre, double precioPorOnza, int nivelProducto) {
        this.nombre = nombre;
        this.precioPorOnza = precioPorOnza;
        this.nivelProducto = nivelProducto;
        this.totalVentas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioPorOnza() {
        return precioPorOnza;
    }

    public int getNivelProducto() {
        return nivelProducto;
    }

    public void setNivelProducto(int nivelProducto) {
        this.nivelProducto = nivelProducto;
    }

    public int getTotalVentas() {
        return totalVentas;
    }

    public void incrementarVentas() {
        totalVentas++;
    }

    // Método abstracto para llenar el producto
    public abstract void llenarProducto();
}