package logic;

public class Tablero {
    private Casilla[][] tablero;

    public Tablero() {
        this.tablero = new Casilla[8][8];
    }

    public void inicializarTablero() {
        // Código para inicializar el tablero
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (j == 1 || j == 6) {
                    Casilla[i][j] = "P";
                } else if ((i == 0 || i == 7) && (j == 0 || j == 7)) {
                    tablero[i][j] = "T";
                } else if ((i == 1 || i == 6) && (j == 0 || j == 7)) {
                    tablero[i][j] = "C";
                } else if ((i == 2 || i == 5) && (j == 0 || j == 7)) {
                    tablero[i][j] = "A";
                } else if (i == 3 && (j == 0 || j == 7)) {
                    tablero[i][j] = "D";
                } else if (i == 4 && (j == 0 || j == 7)) {
                    tablero[i][j] = "R";
                } else {
                    tablero[i][j] = "*";
                }
            }
        }
    }

    public void imprimirTablero() {
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                Casilla casilla = tablero[fila][columna];
                if (casilla.getPieza() != null) {
                    System.out.print(casilla.getPieza().toString() + " ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean juegoTerminado() {
        // Código para determinar si el juego ha terminado
        return true;
    }

    public Jugador turnoActual() {
        // Código para determinar el jugador del turno actual

    }

    public void ejecutarMovimiento(Movimiento movimiento) {
        // Código para ejecutar un movimiento en el tablero
    }
}

