package model;
// Clase abstracta para representar un producto
public abstract class Producto {
    private String nombre;
    private double precioPorOnza;
    private int totalVentas,totalOnzas;

    public Producto(String nombre, double precioPorOnza) {
        this.nombre = nombre;
        this.precioPorOnza = precioPorOnza;
        this.totalVentas = 0;
    }
    public String getNombre() {
        return nombre;
    }
    public double getPrecioPorOnza() {
        return precioPorOnza;
    }
    public int getTotalVentas() {
        return totalVentas;
    }
    public int getTotalOnzas() {
        return totalOnzas;
    }
    public void incrementarVentas() {
        totalVentas++;
    }
    public void incrementarOnzas(int onzas) {
        totalOnzas+=onzas;
    }
    // Método abstracto para llenar el producto
    public abstract String llenarProducto();
}