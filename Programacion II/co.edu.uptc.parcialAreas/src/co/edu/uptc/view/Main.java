package co.edu.uptc.view;

import co.edu.uptc.logic.Circulo;
import co.edu.uptc.logic.Cuadrado;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);
        boolean ciclo =true;
        int x,y,opcion;
        while (ciclo){
            do {
            System.out.println("""
            **************************************
            Elija la Opcion segun desea relizar 
               1= Calcular area de un Circulo
               2= Calcular area del Cuadrado
                          3= salir
            **************************************
            """);
            opcion = cs.nextInt();
            }while (opcion>0 && opcion<4);
            switch (opcion){
//Circulo
                case 1:
                    System.out.println("\n Digite la cordenada en X");
                    x= cs.nextInt();
                    System.out.println("Digite la cordenada en Y");
                    y= cs.nextInt();
                    System.out.println("Digite el Radio del Circulo");
                    Circulo circulo = new Circulo(x, y, cs.nextInt());
                    circulo.dibujar();
                    circulo.rotar();
                    System.out.println("Área del círculo: " + circulo.calcularArea());
                    break;
               //Cuadrado
                case 2:
                    System.out.println("\n Digite la cordenada en X");
                    x= cs.nextInt();
                    System.out.println("Digite la cordenada en Y");
                    y= cs.nextInt();
                    System.out.println("Digite el LADO del Cuadrado");
                    Cuadrado cuadrado = new Cuadrado(0, 0, cs.nextInt());
                    cuadrado.dibujar();
                    cuadrado.rotar();
                    System.out.println("Área del cuadrado :" + cuadrado.calcularArea());

                    break;
                case 3:
                    System.out.println("Gracias por usar  nuestro programa");
                    ciclo=false;
                    break;
                default :
                    System.out.println("opcion invalida dijite de nuevo");;
            }
        }
    }
}