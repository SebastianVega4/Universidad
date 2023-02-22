package co.edu.uptc.view;

import co.edu.uptc.controller.controller;
import javax.swing.*;
import java.util.Objects;

public class main {
    public static void main(String[] args) {
        String menu;
        controller control= new controller();

        do {
            menu =JOptionPane.showInputDialog(null, """
                    Dijite la opcion que desea relizar\s
                    1= numero repeticiones de un mumero en el array
                    2= contar todos los elementos del array\s
                    3= Dijitar un array de su preferencia
                    0= Salir""");
            control.menu(menu);
        }while (!Objects.equals(menu, "0"));

        JOptionPane.showMessageDialog(null,"Hasta pronto");
    }
}
