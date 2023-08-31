package model;
// Clase que representa el producto Latte
public class Latte extends Producto {
    public Latte(double precioPorOnza) {
        super("Express", precioPorOnza);
    }
    @Override
    public String llenarProducto() {
       return """
              
        ***************************************
         Vaso de Latte llenado puede retirarlo
        ***************************************
       """;
    }
}
