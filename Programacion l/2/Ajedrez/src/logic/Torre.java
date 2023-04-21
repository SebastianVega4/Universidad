package logic;

public class Torre extends Pieza {
    public Torre(boolean blanca) {
        super(blanca);
    }

    public boolean esMovimientoValido(Movimiento movimiento) {
        // Código para verificar si el movimiento de la torre es válido
        return true;
    }

    @Override
    public String toString() {
        return null;
    }

}