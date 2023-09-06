package model;

import java.util.Arrays;

public class Recursividad {
    private int cont, contSum, conIMatriz, conJmatriz, resulMatriz;
    private String resul, resulSum, imprimir;
    private final int[][] matriz = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    public Recursividad() {
        this.resul = "";
        this.resulSum = "";
        this.imprimir = "";
    }

    public String imprimirHastaUnN(int x) {
        if (x > 0) {
            imprimir += x + "\n";
            imprimirHastaUnN(x - 1);
        }
        return imprimir;
    }
    public int facR(int n) {
        if (n == 1) return 1;
        return facR(n - 1) * n;
    }
    public String tableMul(int n){
        if(cont != 10){
            cont++;
            resul+=cont+"*"+n+"="+(cont*n)+"\n";
            tableMul(n);
        }
        return resul;
    }

    public String tableSuma(int n) {
        if (contSum < n) {
            contSum++;
            resulSum += contSum + "+" + (n - contSum) + "=" + ((contSum - n) + n) + "\n";
            tableSuma(n);
        }
        return resulSum;
    }

    public int sumaMatriz() {
        if (conIMatriz < matriz.length) {
            if (conJmatriz < matriz[conIMatriz].length) {
                resulMatriz += matriz[conIMatriz][conJmatriz];
                conJmatriz++;
                sumaMatriz();
            } else {
                conIMatriz++;
                conJmatriz = 0;
                sumaMatriz();
            }
        }
        return resulMatriz;
    }

    public String getMatriz() {
        return Arrays.deepToString(matriz);
    }

}
