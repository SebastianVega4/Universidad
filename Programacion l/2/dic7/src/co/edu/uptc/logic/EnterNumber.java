package co.edu.uptc.logic;

public class EnterNumber {
    /**
     * variable estatica uqe dice hasta que numero implimir
     */
    private final int number;

    /**
     * @param number variable int ingresada que indica hasta que numero quiere imprimir el usuario
     */
    public EnterNumber(int number) {
        this.number = number + 1;
    }

    /**
     * ciclo for que imprime hasta number
     */
    public int getFor() {
        for (int i = 0; i < number; i++) {
            System.out.print(" " + i);
        }
        return 0;
    }

    /**
     * ciclo While que imprime hasta number
     */
    public int getWhile() {
        var val = 0;
        while (val != number) {
            System.out.print(" " + val++);
        }
        return 0;
    }
    /**
     * ciclo doWhile que imprime hasta number
     */
    public int getDoWhile() {
        var val = 0;
        do {
            System.out.print(" " + val++);
        } while (val != number);
        return 0;
    }
}
