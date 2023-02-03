package co.edu.uptc.controller;
import co.edu.uptc.logic.*;
import java.util.Scanner;
public class OperateController {
    Scanner sc = new Scanner(System.in);
    public String getmenu(int option){

        //Menu
        switch (option) {
            //fibonacci
            case 1 -> {
                getFibonacci();
            }
            //0-9
            case 2 -> {
                ClassCiclos ciclo = new ClassCiclos();
                System.out.println("FOR");
                ciclo.getFor();
                System.out.println("\nWHILE");
                ciclo.getWhile();
                System.out.println("\nDOWHILE");
                ciclo.getDoWhile();
            }

            //cantidad de numeros a imprimir
            case 3 -> {
                System.out.println("Dijite hasta que numero desea imprimir");
                int number = sc.nextInt();
                EnterNumber valNumber = new EnterNumber(number);
                System.out.println("FOR");
                valNumber.getFor();
                System.out.println("\nWHILE");
                valNumber.getWhile();
                System.out.println("\nDOWHILE");
                valNumber.getDoWhile();
            }

            //pares e impares
            case 4 -> {
                ParEimpar numm = new ParEimpar();
                System.out.println("Numeros Pares");
                numm.getPar();
                System.out.println("\nNumeros Impares");
                numm.getImpar();
            }

            //Capicua
            case 5 -> {
                System.out.println("Digite la palabra a validar");
                String cadena = sc.next();
                Capicua capicua = new Capicua(cadena);
                capicua.getCapicua();
            }

            //Salir
            default -> System.out.println("EXIT");
        }
        return "";
    }
    private String getFibonacci(){
        System.out.println("Digite la cantidad de numeros a imprimir \n" +
                "        del numero fibonacci");
        int tamano = sc.nextInt();
        NumFibonacci num = new NumFibonacci(tamano);


        System.out.println("\ncadena: \n"+num.getCadena());
        return "";
    }

}
