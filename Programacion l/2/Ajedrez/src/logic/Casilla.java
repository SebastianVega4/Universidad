package logic;
public class Casilla {
    private int fila;
    private int columna;
    private Pieza pieza;

    public Casilla(int fila, int columna, Pieza pieza) {
        this.fila = fila;
        this.columna = columna;
        this.pieza = pieza;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public Pieza getPieza() {
        return pieza;
    }

    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }
}
