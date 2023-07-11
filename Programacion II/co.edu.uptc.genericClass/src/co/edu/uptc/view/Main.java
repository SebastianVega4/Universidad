package co.edu.uptc.view;

import co.edu.uptc.logic.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Object> listaPersonas = new ArrayList<>();

        Estudiante estudiante1 = new Estudiante("Juan", 123);
        Estudiante estudiante2 = new Estudiante("María", 456);
        listaPersonas.add(estudiante1);
        listaPersonas.add(estudiante2);

        Profesor profesor1 = new Profesor("Pedro", "Matemáticas");
        Profesor profesor2 = new Profesor("Ana", "Historia");
        listaPersonas.add(profesor1);
        listaPersonas.add(profesor2);

        Administrativos administrativo1 = new Administrativos("Luis", "Recursos Humanos");
        Administrativos administrativo2 = new Administrativos("Laura", "Finanzas");
        listaPersonas.add(administrativo1);
        listaPersonas.add(administrativo2);

        for (Object persona : listaPersonas) {
            System.out.println(persona.toString());
        }
    }
}