package co.edu.uptc.view;


import co.edu.uptc.logic.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante1 = new Estudiante("Sebastian", 201911913);
        Estudiante estudiante2 = new Estudiante("Sara", 202213814);
        Estudiante estudiante3 = new Estudiante("Pedro", 202138455);

        Universidad<Estudiante> universidadEstudiantes = new Universidad<>(estudiante1);
        universidadEstudiantes.mostrarPersona();
        Universidad<Estudiante> universidadEstudiantes2 = new Universidad<>(estudiante2);
        universidadEstudiantes2.mostrarPersona();
        Universidad<Estudiante> universidadEstudiantes3 = new Universidad<>(estudiante3);
        universidadEstudiantes3.mostrarPersona();

        Profesor profesor1 = new Profesor("Carlos", "Sistemas");
        Profesor profesor2 = new Profesor("Ana", "Contaduria");
        Profesor profesor3 = new Profesor("Luis", "Idiomas");

        Universidad<Profesor> universidadProfesores = new Universidad<>(profesor1);
        universidadProfesores.mostrarPersona();
        Universidad<Profesor> universidadProfesores2 = new Universidad<>(profesor2);
        universidadProfesores2.mostrarPersona();
        Universidad<Profesor> universidadProfesores3 = new Universidad<>(profesor3);
        universidadProfesores3.mostrarPersona();
    }
}