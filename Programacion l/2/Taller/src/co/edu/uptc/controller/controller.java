package co.edu.uptc.controller;

import co.edu.uptc.model.model;

import java.util.Objects;

public class controller {
    private final model modelo = new model();
    private final int option = 0;

    public String menu(String menu) {
        if (!Objects.equals(menu, "0")) {
            modelo.imprimirPrimos(Integer.parseInt(menu));
            return modelo.getArray() + " y la suma es igual a : " + modelo.getSum() +
                    "\n el promedio del arreglo es igual a :" + modelo.getProm();
        }else {
            return "Elegiste Salir";
        }
    }
}
