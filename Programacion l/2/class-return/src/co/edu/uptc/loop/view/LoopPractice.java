package co.edu.uptc.loop.view;

import javax.swing.*;

public class LoopPractice {
    public static void main(String[] args) {

        String cadena = "",aux ="";
        int i =0;

        for (int conut = 0; conut <= 10; conut++) {
            if (conut!=10){
                 aux += conut+ ",";
            }else{
                aux += conut;
            }
        }
        JOptionPane.showMessageDialog(null,"For: los numeros son " + aux);
        aux="";

        i=0;
        while(aux!="10"){

            if (i!=10){
                aux += i+ ",";

            }else{
                aux += i;
                break;
            }
            i++;
        }
        JOptionPane.showMessageDialog(null,"while: los numeros son " + aux);
        aux="";

        i=0;
        do{
            if (i!=10){
                aux += i+ ",";
            }else{
                aux += i;
            }
            i++;
        }while(i!=11);
        JOptionPane.showMessageDialog(null,"Do While: los numeros son " + aux);
    }
}
