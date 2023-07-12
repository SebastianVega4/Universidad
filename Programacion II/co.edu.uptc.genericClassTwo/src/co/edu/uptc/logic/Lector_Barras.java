package co.edu.uptc.logic;

public class Lector_Barras<T> {

    private T producto;

    public Lector_Barras(T producto) {
        this.producto = producto;
    }

    public void mostrarProducto() {
        System.out.println(producto.toString());
    }
}

