package Interface;

import Logic.Email;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Email ventana = new Email();
                ventana.setVisible(true);
            }
        });
    }
}