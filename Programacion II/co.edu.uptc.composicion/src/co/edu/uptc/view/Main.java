package co.edu.uptc.view;

import co.edu.uptc.modelo.Examenes;
import co.edu.uptc.modelo.Fecha;

public class Main {
    public static void main(String[] args) {
        Examenes examen = new Examenes("Programación II", "Aula BINF_8");
        //examen.mostrarExamen();
        //@Modificar la fecha y hora del examen

        //Enviando los parametros
        examen.modificarFecha(25, 6, 2023);
        examen.mostrarExamen();
        System.out.println(examen.getFecha());

        //Enbiando el objeto
        Fecha fecha = new Fecha(30, 6, 2024);
        examen.modificarFecha(fecha);
        examen.mostrarExamen();
        System.out.println(examen.getFecha());


        //examen.modificarHora(12, 10);
        //examen = null;
    }
}