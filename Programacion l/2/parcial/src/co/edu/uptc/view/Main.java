package co.edu.uptc.view;

import co.edu.uptc.controller.ControllerStore;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        ControllerStore objet = new ControllerStore();

        objet.getNombre(JOptionPane.showInputDialog("Ingresa el Nombre del producto"));
        objet.getPcompra(Integer.parseInt(JOptionPane.showInputDialog("Ingresa el Nombre del producto")));
        objet.getPventa(Integer.parseInt(JOptionPane.showInputDialog("Ingresa el Precio de venta")));
        objet.getPeso(Integer.parseInt(JOptionPane.showInputDialog("Ingresa el Peso del producto")));
        objet.getAlto(Integer.parseInt(JOptionPane.showInputDialog("Ingresa el Alto del producto")));
        objet.getAncho(Integer.parseInt(JOptionPane.showInputDialog("Ingresa el Ancho del producto")));
    }
}
