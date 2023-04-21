package co.edu.uptc.view;

import co.edu.uptc.controller.Controller;

import javax.swing.*;

public class Main {
    long startTime = System.nanoTime();

    public static void main(String[] args) {
        Controller control = new Controller();
        String oInicial;
        control.generarVehiculosAleatorios();

        do {

            oInicial = JOptionPane.showInputDialog(null, """
                    ************************************************
                    Dijite el numero segun la accion a relizar:
                        1=Ordenar     2=Buscar     3=Salir
                    ************************************************
                    """);
            switch (oInicial) {
                case "1" -> {
                    String[] orde = {"Quick", "Merge", "Burbuja", "Shell", "Insercion", "Seleccion"};
                    String ordenamiento = (String) JOptionPane.showInputDialog(null, "Selecione el algoritmo de Ordenamiento",
                            "ORDENAMIETO", JOptionPane.INFORMATION_MESSAGE, null, orde, null);
                    control.ordenarVehiculos(ordenamiento);
                }
                case "2" -> {

                    String[] busque = {"Lineal", "Binaria"};
                    String busqueda = (String) JOptionPane.showInputDialog(null, "Selecione el algoritmo de Ordenamiento",
                            "BUSQUEDA", JOptionPane.INFORMATION_MESSAGE, null, busque, null);
                    control.buscarVehiculo(busqueda);
                }
                case "3" -> control.salir();
                default -> JOptionPane.showMessageDialog(null, "Seleccione una opcion valida");
            }
        } while (!oInicial.equals("3"));
    }
}