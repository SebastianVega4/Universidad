package model;
// Clase que representa el producto Cappuccino
public class Cappuccino extends Producto {
    public Cappuccino(double precioPorOnza) {
        super("Express", precioPorOnza);
    }
    @Override
    public String llenarProducto() {
        return """
              
         ********************************************
          Vaso de Cappuccino llenado puede retirarlo
         ********************************************
         """;
    }
}
