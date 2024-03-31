package View;

import Controller.ControllerPlayer;
import Controller.RunnableDices;
import Model.Player;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

      SwingUtilities.invokeLater(() -> {
            principalPanel panel = new principalPanel();
            panel.principal();

        });
    }
}
