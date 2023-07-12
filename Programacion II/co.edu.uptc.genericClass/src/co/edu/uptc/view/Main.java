package co.edu.uptc.view;

import co.edu.uptc.logic.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Object> listaPersonas = new ArrayList<>();

        Estudiante estudiante1 = new Estudiante("Juan", 201911913);
        Estudiante estudiante2 = new Estudiante("María", 202059683);
        listaPersonas.add(estudiante1);
        listaPersonas.add(estudiante2);

        Profesor profesor1 = new Profesor("Pedro", "Sistemas");
        Profesor profesor2 = new Profesor("Ana", "Contabilidad");
        listaPersonas.add(profesor1);
        listaPersonas.add(profesor2);

        Administrativos administrativo1 = new Administrativos("Luis", "Recursos Humanos");
        Administrativos administrativo2 = new Administrativos("Laura", "Finanzas");
        listaPersonas.add(administrativo1);
        listaPersonas.add(administrativo2);

        for (Object persona : listaPersonas) {
            if (persona instanceof Estudiante) {
                Estudiante estudiante = (Estudiante) persona;
                System.out.println("Estudiante: " + estudiante.getName() + ", Código: " + estudiante.getCod());
            } else if (persona instanceof Profesor) {
                Profesor profesor = (Profesor) persona;
                System.out.println("Profesor: " + profesor.getName() + ", Escuela: " + profesor.getEscuela());
            } else if (persona instanceof Administrativos) {
                Administrativos administrativo = (Administrativos) persona;
                System.out.println("Administrativo: " + administrativo.getName() + ", Área: " + administrativo.getArea());
            }
        }
    }
}