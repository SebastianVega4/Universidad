import java.awt.*;

public class Rectangle extends Figure{

    private double width;
    private double height;

    public Rectangle(Point point, Color color,double width, double height) {
        super(point,color);
        this.width = width;
        this.height = height;
    }

    @Override
    public void drawFigure(Graphics graphics) {
        graphics.setColor( color );
        graphics.drawRect(point.x, point.y, (int)width, (int)height );
    }

    @Override
    public double calcArea() {
        return width * height;
    }
}
