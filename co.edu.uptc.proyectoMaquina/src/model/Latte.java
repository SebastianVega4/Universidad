package model;
// Clase que representa el producto Latte
public class Latte extends Producto {
    public Latte(double precioPorOnza, int nivelProducto) {
        super("Express", precioPorOnza, nivelProducto);
    }
    @Override
    public void llenarProducto() {
        // Lógica para llenar el producto Latte
    }
}
