package co.edu.uptc.loop.view;
import co.edu.uptc.loop.controller.LoopController;

import javax.swing.*;

public class Loop {
    public static void main(String[] args) {
        LoopController controlador = new LoopController();

        String cadena = "";
        String aux = "";
        int i = 0;

        for (int conut = 0; conut <= 10; conut++) {
            if (conut != 10) {
                aux += conut + ",";
            } else {
                aux += conut;
            }
        }

        JOptionPane.showMessageDialog(null, "For: los numeros son " + aux);


        JOptionPane.showMessageDialog(null, "while: los numeros son " + aux);
        JOptionPane.showMessageDialog(null, "Do While: los numeros son " + aux);
    }
}
