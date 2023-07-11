package co.edu.uptc.logic;

public class Cuadrado extends Figura implements Rotable, Dibujable {
    private final int lado;
    public Cuadrado(int x, int y, int lado) {
        super(x, y);
        this.lado = lado;
    }
    @Override
    public void dibujar() {
        System.out.println("Dibujando una cuadrado en la posición (" + super.getX() + ", " + super.getY() + ")");
    }
    @Override
    public void rotar() {
        System.out.println("Rotando el cuadrado");
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }
}
