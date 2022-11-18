import java.awt.*;

public class Triangle extends Figure{
    private Point pointTwo;
    private Point pointThree;

    public Triangle(Point point, Color color, Point pointTwo, Point pointThree) {
        super(point, color);
        this.pointTwo = pointTwo;
        this.pointThree = pointThree;
    }

    @Override
    public void drawFigure(Graphics graphics) {
        graphics.setColor( color );
        int[] pointX = {point.x, pointTwo.x, pointThree.x, };
        int[] pointY = {point.y, pointTwo.y, pointThree.y};
        graphics.drawPolyline( pointX,pointY, pointX.length);
    }

    @Override
    public double calcArea() {
        //TODO calculo del área
        return 0;
    }

    public String getType(){
        return "Qué tipo de Triangulo soy";
    }
}
