import  java.awt.*;
public class Triangle extends  Figure {
    private  Point pointTWO;
    private Point PointThree;

    public Triangle(Point point, Color color, Point pointTWO, Point pointThree) {
        super(point, color);
        this.pointTWO = pointTWO;
        PointThree = pointThree;
    }

    @Override
    public void drawFigure(Graphics graphics) {
        int[] pointX ={point.x,point.y,point.x};
        int[] pointY ={point.x,point.y,point.x};
        graphics.drawPolygon(pointX,pointY,pointX.length);
    }

    @Override
    public double calcArea() {
        return 0;
    }
    public String getType(){
        return "que tipo de triangulo soy";
        
    }
}
