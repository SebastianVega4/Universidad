package View;

import Model.controller;

import javax.swing.*;
import java.awt.*;

public class GUIdictionary {
    private final JFrame frame;
    private static controller control;

    public GUIdictionary(){
        frame = new JFrame("Diccionario");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(950, 680);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        control = new controller();
    }
    public void showDictionaryPanel() {
        GUIdictionaryPanel guIdictionaryPanel = new GUIdictionaryPanel(this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(guIdictionaryPanel.getPanel(), BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    public static controller getControl() {
        return control;
    }

    public JFrame getFrame() {
        return frame;
    }
}