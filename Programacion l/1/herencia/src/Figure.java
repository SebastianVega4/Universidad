import java.awt.*;

public abstract class Figure implements ActionsFigure {
    protected Point point;
    protected Color color;

    public Figure(Point point, Color color) {
        this.point = point;
        this.color = color;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

}

