package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class model {
    String nPrimis[];
    int aux=0;
    public boolean esPrimo(int numero) {
        if (numero == 0 || numero == 1 || numero == 4) {
            return false;
        }
        for (int x = 2; x < numero / 2; x++) {
            if (numero % x == 0)
                return false;
        }
        return true;
    }

    public String[] imprimirPrimos(int numero) {
        nPrimis = new String[44];
        for (int x = 0; x <= numero; x++) {
            if (esPrimo(x)) {
                aux++;
                nPrimis[aux] = String.valueOf(x);
            }
        }
        return nPrimis;
    }
    public String[] getArray() {
        List<String> arraySinNull = new ArrayList<>(Arrays.asList(nPrimis));
        while (arraySinNull.remove(null)) {}
        nPrimis= arraySinNull.toArray(new String[0]);
        return nPrimis;
    }
    public int getSum() {
       int sum = 0;
        for (int i = 0; i < getArray().length; i++) {
            sum = sum + Integer.parseInt(nPrimis[i]);
        }
        return sum;
    }

    public double getProm(){
        double prom,total,suma;
        total = nPrimis.length;
        suma = getSum();
        prom = suma/total;
        return prom;
    }


}