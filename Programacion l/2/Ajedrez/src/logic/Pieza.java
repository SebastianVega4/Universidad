package logic;

public abstract class Pieza {
    private boolean blanca;

    public Pieza(boolean blanca) {
        this.blanca = blanca;
    }

    public boolean esBlanca() {
        return blanca;
    }

    public abstract boolean esMovimientoValido(Movimiento movimiento);

    public abstract String toString();
}
