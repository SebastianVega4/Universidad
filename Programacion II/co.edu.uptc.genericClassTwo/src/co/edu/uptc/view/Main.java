package co.edu.uptc.view;

import co.edu.uptc.logic.Computador;
import co.edu.uptc.logic.Lector_Barras;
import co.edu.uptc.logic.Televisor;

public class Main {
    public static void main(String[] args) {
        Computador computador1 = new Computador("Computador 1", 1000.0);
        Computador computador2 = new Computador("Computador 2", 1500.0);
        Computador computador3 = new Computador("Computador 3", 2000.0);

        Televisor televisor1 = new Televisor("Televisor 1", 500.0);
        Televisor televisor2 = new Televisor("Televisor 2", 800.0);
        Televisor televisor3 = new Televisor("Televisor 3", 1200.0);

        Lector_Barras<Computador> lectorComputador = new Lector_Barras<>(computador1);
        Lector_Barras<Televisor> lectorTelevisor = new Lector_Barras<>(televisor1);

        lectorComputador.mostrarProducto();
        lectorTelevisor.mostrarProducto();
    }
}