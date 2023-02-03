package co.edu.uptc.logic;

public class ParEimpar {
    /**
     * calcula e imprime los numeros pares del 0 al 10
     */
    public int getPar() {
        for (int i = 0; i <= 10; i++) {
            if ((i % 2) == 0) {
                System.out.print(i + " ");
            }
        }
        return 0;
    }
    /**
     * calcula e imprime los numeros Impares del 0 al 10
     */
    public int getImpar() {
        for (int i = 0; i <= 10; i++) {
            if ((i % 2) != 0) {
                System.out.print(i + " ");
            }
        }
        return 0;
    }
}