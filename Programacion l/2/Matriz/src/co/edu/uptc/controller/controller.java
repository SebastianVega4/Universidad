package co.edu.uptc.controller;

import co.edu.uptc.model.model;

import java.util.Arrays;

public class controller {
    model cs = new model();
    public String Star(String f, String c) {
        cs.rellenarMatriz(Integer.parseInt(f), Integer.parseInt(c));
        return "la matriz es :" + Arrays.deepToString(cs.getMatriz()) +
                "\n y los numeros menores de es matriz son : "+ Arrays.toString(cs.numberMenor());
    }
}
