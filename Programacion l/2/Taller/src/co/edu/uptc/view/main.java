package co.edu.uptc.view;

import co.edu.uptc.controller.controller;
import co.edu.uptc.model.model;

import javax.swing.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        String menu;
        controller control= new controller();
        model cd = new model();
        do {
            menu =JOptionPane.showInputDialog(null,"Dijite hasta el numero que desea calcular los primos \n" +
                    "\n" +
                    "Digite 0 para salir");
            JOptionPane.showMessageDialog(null,control.menu(menu));
        }while (!Objects.equals(menu, "0"));

        JOptionPane.showMessageDialog(null,"Hasta pronto");

    }

}
