package co.edu.uptc.view;

import co.edu.uptc.controller.controller;

import javax.swing.*;

public class main {
    public static void main(String[] args) {
        controller main = new controller();

        String filas, columnas;
        filas = JOptionPane.showInputDialog(null, "ingrese el numero se filas");
        columnas = JOptionPane.showInputDialog(null, "ingrese el numero se columnas");
        JOptionPane.showMessageDialog(null, main.Star(filas, columnas));
    }
}
