package co.edu.uptc.view;

import co.edu.uptc.controller.controller;
import co.edu.uptc.model.model;

import javax.swing.*;
import java.util.Objects;

public class main {
    public static void main(String[] args) {
        String menu;
        controller control = new controller();
        do {
            menu = JOptionPane.showInputDialog(null, "Dijite hasta el numero que desea calcular los primos" +
                    "\n" +
                    "Digite 0 para salir");
            JOptionPane.showMessageDialog(null, control.menu(menu));
        } while (!Objects.equals(menu, "0"));
        JOptionPane.showMessageDialog(null, "Hasta pronto");
    }
}
