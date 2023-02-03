package co.edu.uptc.logic;

public class ClassCiclos {
    /**
     * variable estatica uqe dice hasta que numero implimir
     */
    private final int number = 10;

    /**
     * ciclo for que imprime del 0 al 9
     */
    public int getFor() {
        for (int i = 0; i < number; i++) {
            System.out.print(" " + i);
        }
        return 0;
    }
    /**
     * ciclo While que imprime del 0 al 9
     */
    public int getWhile() {
        var val = 0;
        while (val != number) {
            System.out.print(" " + val++);
        }
        return 0;
    }
    /**
     * ciclo doWhile que imprime del 0 al 9
     */
    public int getDoWhile() {
        var val = 0;
        do {
            System.out.print(" " + val++);
        } while (val != number);
        return 0;
    }
}
