package model;
// Clase que representa el producto Express
public class Express extends Producto {
    public Express(double precioPorOnza, int nivelProducto) {
        super("Express", precioPorOnza, nivelProducto);
    }
    @Override
    public void llenarProducto() {
        // Lógica para llenar el producto Express
    }
}
