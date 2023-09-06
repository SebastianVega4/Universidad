package model;
// Clase que representa el producto Express
public class Express extends Producto {
    public Express(double precioPorOnza) {
        super("Express", precioPorOnza);
    }
    @Override
    public String llenarProducto() {
        return """
              
         ******************************************
          Vaso de Expresso llenado puede retirarlo
         ******************************************
         """;
    }
}
