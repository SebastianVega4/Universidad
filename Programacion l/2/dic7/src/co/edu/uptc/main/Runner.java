package co.edu.uptc.main;
import co.edu.uptc.controller.OperateController;
import co.edu.uptc.logic.*;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        OperateController myController = new OperateController();
        Scanner sc = new Scanner(System.in);
        int option=0;
        do {
            System.out.println("\n***************************************************************************");
            System.out.println("1= Numero Fibonacci    2=imprimir 0-9 ciclos     3= Imprimir n numeros\n" +
                    "             4=Pares e Impares    5=Capicua   6=SALIR" );
            System.out.println("***************************************************************************");
            option = sc.nextInt();
        }while (option < 1 || option > 6);
         myController.getmenu(option);

    }
}
