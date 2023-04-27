package co.edu.uptc.view;

import co.edu.uptc.controller.Controller;

import javax.swing.*;

public class GameView {
    public static void main(String[] args) {
            Controller controller = new Controller();
            Object[] options = {"Aceptar", "Salir"};
            while (true) {
                try {
                String movimiento = JOptionPane.showInputDialog("""
                               Ingresa tu movimiento en el formato:
                        fila Inicial, Columba Inicial, nueva Fila, nueva Columna
                         
                        """ + controller.showBoard());
                    String String = null;
                    if (movimiento == null) {
                    JOptionPane.showMessageDialog(null, "Digite algun valor");
                    continue;
                }

                boolean validMove = controller.entradaMove(movimiento);
                if (!validMove) {
                    controller.showInvalidMoveMessage();
                } else {
                    // verificar si el jugador quiere salir
                    // y terminar el ciclo while en caso afirmativo
                    String validaSalir = java.lang.String.valueOf(JOptionPane.showOptionDialog(null, """
                                                movimiento efectuado
                                    """ + controller.showBoard(),
                            "Juego Ajedrez", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null, options, options[0]));
                    if (validaSalir.equals("1")) {
                        JOptionPane.showMessageDialog(null, "Hasta pronto");
                        break;
                    }
                }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + e.getMessage());
                }

            }

    }
}