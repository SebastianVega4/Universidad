package main;
import logic.*;
import java.util.Scanner;

public class runner {
    public static void main(String[] args) {
        getmenu();
    }

    private static void getmenu(){
        int option;
        Scanner sc = new Scanner(System.in);
        //Menu
        do {
            System.out.println("\n***************************************************************************");
            System.out.println("1= Numero Fibonacci    2=imprimir 0-9 ciclos     3= Imprimir n numeros\n" +
                    "             4=Pares e Impares    5=Capicua   6=SALIR" );
            System.out.println("***************************************************************************");
            option = sc.nextInt();
        }while (option < 1 || option > 6);

        switch (option) {
            //fibonacci
            case 1:
                System.out.println("Digite la cantidad de numeros a imprimir \n" +
                        "        del numero fibonacci");
                int tamano = sc.nextInt();
                nFibonacci num = new nFibonacci(tamano);
                num.getnumer();
                getmenu();
                break;
            //0-9
            case 2:
                classCiclos ciclo =new classCiclos();
                System.out.println("FOR");
                ciclo.getFor();
                System.out.println("\nWHILE");
                ciclo.getWhile();
                System.out.println("\nDOWHILE");
                ciclo.getDoWhile();
                getmenu();
                break;
            //cantidad de numeros a imprimir
            case 3:
                System.out.println("Dijite hasta que numero desea imprimir");
                int number=sc.nextInt();
                enterNumber valNumber =new enterNumber(number);
                System.out.println("FOR");
                valNumber.getFor();
                System.out.println("\nWHILE");
                valNumber.getWhile();
                System.out.println("\nDOWHILE");
                valNumber.getDoWhile();
                getmenu();
                break;
            //pares e impares
            case 4:
                parEImpar numm = new parEImpar();
                System.out.println("Numeros Pares");
                numm.getPar();
                System.out.println("\nNumeros Impares");
                numm.getImpar();
                getmenu();
                break;
            //Capicua
            case 5:
                System.out.println("Digite la palabra a validar");
                String cadena = sc.next();
                capicua capicua = new capicua(cadena);
                capicua.getCapicua();
                getmenu();
                break;
            //Salir
            default:
                System.out.println("EXIT");
        }
    }
}
