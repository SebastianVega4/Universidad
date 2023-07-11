package co.edu.uptc.logic;

import java.util.ArrayList;

public class BaseDatos<T> {
    private ArrayList<T> listaPersonas;
    public BaseDatos() {
        listaPersonas = new ArrayList<>();
    }

    public void agregarPersona(T persona) {
        listaPersonas.add(persona);
    }

    public void mostrarPersonas() {
        for (T persona : listaPersonas) {
            System.out.println(persona.toString());
        }
    }
}
