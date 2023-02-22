package co.edu.uptc.controller;

import co.edu.uptc.model.model;

import javax.swing.*;
import java.util.Arrays;
import java.util.Objects;

public class controller {
    private model modelo = new model();
    private final int[] cadena1 = new int[]{1,2,3,3,2,1,0};
    private int option = 0;

    public void menu (String menu){

        if (Objects.equals(menu, "1")){
            modelo.calNumRepeat(cadena1,
                    Integer.parseInt(JOptionPane.showInputDialog(null,"dijite el dijito a evaluar")));
            JOptionPane.showMessageDialog(null,"en el array el numero se repite  "+modelo.getNumRepeat());
        } else if (Objects.equals(menu, "2")) {
            modelo.valueRepeaTotal(cadena1);
            JOptionPane.showMessageDialog(null, Arrays.toString(modelo.getRepeaTotal()));
        } else if (Objects.equals(menu, "3")) {
            modelo.setSepararArray(JOptionPane.showInputDialog(null,"Dijite los valores del array separados por ,"));
            modelo.RepeatTotalUser();
            JOptionPane.showMessageDialog(null, Arrays.toString(modelo.getRepeaTotalUser()));
        }
    }

}
