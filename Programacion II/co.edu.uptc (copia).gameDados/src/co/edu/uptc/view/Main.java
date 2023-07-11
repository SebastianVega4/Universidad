package co.edu.uptc.view;

import co.edu.uptc.logic.GameDados;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean ciclo = true;
        int opcion;
        Scanner cs = new Scanner(System.in);

        while (ciclo) {
            System.out.println("Bienvenidos al juego \n digite 1 si desea iniciar y 2 si desea salir");
            opcion = cs.nextInt();
            GameDados gameDados = new GameDados();
            if (opcion == 1) {
                System.out.println(gameDados.iniciar());
                System.out.println(gameDados.jugar());
                System.out.println(gameDados.finalizar());
                System.out.println("\n digite 1 si jugar nuevo y 2 si desea salir");
                if (cs.nextInt() == 2) {
                    ciclo = false;
                }
            }
        }
    }
}