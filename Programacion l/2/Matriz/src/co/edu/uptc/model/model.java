package co.edu.uptc.model;

import java.util.Arrays;

public class model {
    private int[][] matriz;
    private int[] nTotal;
    private int naux;

    public void rellenarMatriz(int filas, int columnas) {
        matriz = new int[filas][columnas];
        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[f].length; c++) {
                matriz[f][c] = (int) (Math.random() * 20) + 1;
            }
        }
    }

    public int[] numberMenor() {
        nTotal = new int[matriz.length];
        int nMenor = 99;
        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[f].length; c++) {
                naux = matriz[f][c];
                if (nMenor > naux) {
                    nTotal[f] = naux;
                }
            }
        }
        return nTotal;
    }
    public int[][] getMatriz() {
        return matriz;
    }
    @Override
    public String toString() {
        return "model{" +
                "matriz=" + Arrays.toString(matriz) +
                ", nTotal=" + Arrays.toString(nTotal) +
                ", naux=" + naux +
                '}';
    }
}