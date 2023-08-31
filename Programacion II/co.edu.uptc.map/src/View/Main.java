package View;

import Model.Estudent;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Estudent> alumnos = new TreeSet<>();
        alumnos.add(new Estudent("Juan", 3.2));
        alumnos.add(new Estudent("María", 2.5));
        alumnos.add(new Estudent("Pedro", 4.0));

        System.out.println("Alumnos ordenados por calificacion: " + alumnos);
    }
}