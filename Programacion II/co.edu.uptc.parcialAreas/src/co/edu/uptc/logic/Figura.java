package co.edu.uptc.logic;

public abstract class Figura {
    protected int x;
    protected int y;
    public Figura(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public abstract double calcularArea();
}
