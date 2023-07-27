package model;
// Clase que representa el producto Cappuccino
public class Cappuccino extends Producto {
    public Cappuccino(double precioPorOnza, int nivelProducto) {
        super("Express", precioPorOnza, nivelProducto);
    }
    @Override
    public void llenarProducto() {
        // Lógica para llenar el producto Cappuccino
    }
}
