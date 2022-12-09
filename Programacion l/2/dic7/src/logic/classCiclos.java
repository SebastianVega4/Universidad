package logic;

public class classCiclos {
    /**
     * variable estatica uqe dice hasta que numero implimir
     */
    private final int number = 10;

    /**
     * ciclo for que imprime del 0 al 9
     */
    public void getFor() {
        for (int i = 0; i < number; i++) {
            System.out.print(" " + i);
        }
    }
    /**
     * ciclo While que imprime del 0 al 9
     */
    public void getWhile() {
        var val = 0;
        while (val != number) {
            System.out.print(" " + val);
            val++;
        }
    }
    /**
     * ciclo doWhile que imprime del 0 al 9
     */
    public void getDoWhile() {
        var val = 0;
        do {
            System.out.print(" " + val);
            val++;
        } while (val != number);
    }
}
