package co.edu.uptc.view;

import co.edu.uptc.logic.Computador;
import co.edu.uptc.logic.Lector_Barras;
import co.edu.uptc.logic.Televisor;

public class Main {
    public static void main(String[] args) {


    Computador computador1 = new Computador("HP", 2_000_000.0);
    Computador computador2 = new Computador("LENOVO", 1_000_000.0);
    Computador computador3 = new Computador("ASUS", 1_500_000.0);
    Televisor televisor1 = new Televisor("SAMSUUNG", 4_000_000.0);
    Televisor televisor2 = new Televisor("HYUNDAI", 2_000_000.0);
    Televisor televisor3 = new Televisor("HP", 8_000_000.0);


    }
}