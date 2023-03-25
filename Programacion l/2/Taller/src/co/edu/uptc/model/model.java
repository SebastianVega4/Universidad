package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.List;

public class model {
    List<String> nPrimis = new ArrayList<>();
    int aux = 0;

    public boolean esPrimo(int numero) {
        if (numero == 0 || numero == 1 || numero == 4) {
            return false;
        }
        //                    10
        //                     5
        for (int x = 2; x < numero / 2; x++) {
                //5
            if (numero % x == 0)
                return false;
        }
        return true;
    }

    public void imprimirPrimos(int numero) {
        nPrimis.clear();
        for (int x = 0; x <= numero; x++) {
            if (esPrimo(x)) {
                aux++;
                nPrimis.add(String.valueOf(x));
            }
        }
    }

    public List<String>  getArray() {
        return nPrimis;
    }

    public int getSum() {
        int sum = 0;
        for (int i = 0; i < getArray().size(); i++) {
            sum = sum + Integer.parseInt(nPrimis.get(i));
        }
        return sum;
    }

    public double getProm() {
        double prom, total, suma;
        total = nPrimis.size();
        suma = getSum();
        prom = suma / total;
        return prom;
    }
}