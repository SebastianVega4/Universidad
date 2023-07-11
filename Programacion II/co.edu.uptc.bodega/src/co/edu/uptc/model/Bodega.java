package co.edu.uptc.model;

import java.util.Arrays;

public class Bodega {
    private Producto lisprod[];
    private int cont ;

    public Bodega() {
        Producto lapiz= new Producto("111","Lapiz",2_000);
        Producto borrador = new Producto("222","borrador",1_000);
        Producto cuederno = new Producto("333","cuaderno",6_000);
    }

    public void mgresoProd(Producto producto){
        lisprod[cont] = producto;
        cont++;
    }

    @Override
    public String toString() {
        return "Bodega{" +
                "lisprod=" + Arrays.toString(lisprod) +
                '}';
    }
}
