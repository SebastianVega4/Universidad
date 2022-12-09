package logic;

public class enterNumber {
    /**
     * variable estatica uqe dice hasta que numero implimir
     */
    private final int number;

    /**
     * @param number variable int ingresada que indica hasta que numero quiere imprimir el usuario
     */
    public enterNumber(int number) {
        this.number = number + 1;
    }

    /**
     * ciclo for que imprime hasta number
     */
    public void getFor() {
        for (int i = 0; i < number; i++) {
            System.out.print(" " + i);
        }
    }

    /**
     * ciclo While que imprime hasta number
     */
    public void getWhile() {
        var val = 0;
        while (val != number) {
            System.out.print(" " + val);
            val++;
        }
    }
    /**
     * ciclo doWhile que imprime hasta number
     */
    public void getDoWhile() {
        var val = 0;
        do {
            System.out.print(" " + val);
            val++;
        } while (val != number);
    }
}
