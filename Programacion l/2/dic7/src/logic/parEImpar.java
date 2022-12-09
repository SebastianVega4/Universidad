package logic;

public class parEImpar {
    /**
     * calcula e imprime los numeros pares del 0 al 10
     */
    public void getPar() {
        for (int i = 0; i <= 10; i++) {
            if ((i % 2) == 0) {
                System.out.print(i + " ");
            }
        }
    }

    /**
     * calcula e imprime los numeros Impares del 0 al 10
     */
    public void getImpar() {
        for (int i = 0; i <= 10; i++) {
            if ((i % 2) != 0) {
                System.out.print(i + " ");
            }
        }

    }
}
