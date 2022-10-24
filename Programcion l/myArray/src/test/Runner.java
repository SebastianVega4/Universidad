package test;

import javax.swing.*;
import java.util.Random;

public class Runner {
    private int[] array;

    public static void main(String[] args) {
        /*
        //Definir un arreglo
        int[] vector = new int[10];

        //asignar valores
        vector[0] = 34241;
        vector[9] = 543;

        for ( int index = 0 ; index < vector.length ; index++ ){
            System.out.print( vector[ index ] + "\t");
        }

        System.out.println("\nEl tamaño del vector es " + vector.length );



        int[] array = getArray( 200 );
        showArray( array );

        showArray( getArray(1000));*/

        new Runner().begin();
    }

    private void begin() {
        String menu = ">>>>>>MENU PRINCIPAL<<<<<<\n\n" +
                "A. Dimensionar arreglo\n" +
                "B. Visualizar Arreglo\n" +
                "C. Hallar el Mayor\n" +
                "D. Hallar el Menor\n" +
                "E. Hallar la Suma\n" +
                "F. Hallar el Promedio\n" +
                "G. Contar Pares/Impares\n" +
                "H. Visualizar Primos\n" +
                "I. Contar Repetido\n" +
                "X Salir\n\nDigite su Opcion";

        char option=' ';
        do{
            option = Character.toUpperCase(JOptionPane.showInputDialog( menu ).charAt( 0 ));
            switch(option){
                case 'A' -> dimArray();

                case 'B' -> viewArray();

                case 'X' -> exit();

                default -> JOptionPane.showMessageDialog(null,"Opcion no Válida","Error",JOptionPane.ERROR_MESSAGE);
            }
        }while( true );
    }

    private void exit() {

        int exit = JOptionPane.showConfirmDialog(null,"Desea Salir?","Confirmar",JOptionPane.YES_NO_OPTION);
        if( exit == JOptionPane.YES_OPTION){
            System.exit( 0 );
        }
    }

    private void viewArray() {
        //TODO Visualizar los elementos del arreglo en una sola línea
        System.out.println("Visualiza el Arreglo");
    }

    private void dimArray() {
        //TODO leer el tamaño y dimensionar el arreglo
        System.out.println("Dimensiona el Arreglo");
    }

    /***
     * Inicializa, asigna valores aleatorios y reorna un arreglo
     * @param size especifica el tamaño del arreglo
     * @return el arreglo con los elementos asignados
     */
    static public int[] getArray( int size ){
        int[ ] array = new int[ size ];

        for ( int index = 0 ; index < array.length ; index++ ){
            array[index] = new Random().nextInt(91) + 10;
        }

        return array;
    }

    static void showArray( int[] array ){
        System.out.print("[");
        for ( int index = 0 ; index < array.length ; index++ ){
            System.out.print( array[ index ]);
            if( index < array.length - 1 ){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

}