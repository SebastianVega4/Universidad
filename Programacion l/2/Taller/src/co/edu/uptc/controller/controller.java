package co.edu.uptc.controller;

import co.edu.uptc.model.model;

import java.util.Arrays;

public class controller {
    private model modelo = new model();
    private int option = 0;

    public String menu(String menu){
        modelo.imprimirPrimos(Integer.parseInt(menu));
       return Arrays.toString(modelo.getArray()) +" y la suma es igual a : "+ modelo.getSum() +
               "\n el promedio del arreglo es igual a :" + modelo.getProm();
    }
}
