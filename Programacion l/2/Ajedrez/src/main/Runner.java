package main;
import logic.Jugador;
import logic.Movimiento;
import logic.Tablero;

public class Runner {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        tablero.inicializarTablero();
        tablero.imprimirTablero();
        while (!tablero.juegoTerminado()) {
            Jugador jugador = tablero.turnoActual();
            Movimiento movimiento = jugador.elegirMovimiento(tablero);
            tablero.ejecutarMovimiento(movimiento);
            tablero.imprimirTablero();
        }
        System.out.println("Fin del juego!");
        System.out.println();
    }
}
