package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class model {
    private int numRepeat = 0;
    private String[] repeatTotal;
    private String[] user;

    public void calNumRepeat(int[] cadena, int numCal) {
        int repeat = 0;
        for (int i = 0; i < cadena.length; i++) {
            if (cadena[i] == numCal) {
                repeat += 1;
            }
        }
        numRepeat = repeat;
    }

    public int getNumRepeat() {
        return numRepeat;
    }

    public void valueRepeaTotal(int[] cadena) {
        repeatTotal = new String[cadena.length];
        for (int i = 0; i < cadena.length; i++) {
            int aux = 0,repeticiones=0;
            for (int j = 0; j < cadena.length; j++) {
                if (cadena[i]==cadena[j] ) {
                    aux++;
                    repeticiones++;
                    if (aux!=1){
                        cadena[j]=999999;
                    }
                }
            }
            if (cadena[i]!=999999){
                repeatTotal[i] = "El numero " + cadena[i] + " se repite " + aux + " veces \n";
            }
        }
    }

    public String[] getRepeaTotal() {
        List<String> arraySinNull = new ArrayList<>(Arrays.asList(repeatTotal));
        while (arraySinNull.remove(null)) {}
        repeatTotal = arraySinNull.toArray(new String[0]);
        return repeatTotal;
    }

    public void setSepararArray(String cadena) {
        user = new String[((cadena.length()/2)+1)];
        int aux =0;
        for (int i = 0; i < cadena.length(); i++) {
            String c = String.valueOf(cadena.charAt(i));
            if (!c.equals(",")) {
                user[i-aux] = c;
                aux++;
            }
        }
    }

    public void RepeatTotalUser(){
        repeatTotal = new String[user.length];
        for (int i = 0; i < user.length; i++) {
            int aux = 0;
            for (int j = 0; j < user.length; j++) {
                if (Objects.equals(user[j], user[i])) {
                    aux++;
                    if (aux!=1) {
                        user[j] = null;
                    }
                }
            }
            if (user[i]!=null){
                repeatTotal[i] = "El numero " + user[i] + " se repite " + aux + " veces \n";
            }
        }
    }
    public String[] getRepeaTotalUser() {
        List<String> arraySinNull = new ArrayList<>(Arrays.asList(repeatTotal));
        while (arraySinNull.remove(null)) {}
        repeatTotal = arraySinNull.toArray(new String[0]);
        return repeatTotal;
    }
}