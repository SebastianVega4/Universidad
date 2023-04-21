package logic;

public class Peon extends Pieza {
    public Peon(boolean blanca) {
        super(blanca);
    }

    public boolean esMovimientoValido(Movimiento movimiento) {
        // Código para verificar si el movimiento del peón es válido
        return true;
    }

    public String toString() {
        if (esBlanca()) {
            return "P";
        } else {
            return "p";
        }
    }
}

