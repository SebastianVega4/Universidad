import java.awt.*;

public class Circle extends Figure{

    private double radio;

    public Circle(Point point, Color color, double radio) {
        super(point,color );
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public void drawFigure(Graphics graphics) {
        graphics.setColor( color );
        graphics.drawOval( point.x, point.y, (int)radio, (int)radio);
    }

    @Override
    public double calcArea() {
        return Math.PI * Math.pow(radio,2);
    }
}
