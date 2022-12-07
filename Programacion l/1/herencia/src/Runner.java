import javax.swing.*;
import java.awt.*;

public class Runner {
    public static void main(String[] args) {
        Window myWindow = new Window("Ejemplo de Pintar");
        myWindow.setVisible( true );

        //Un circulo es una figura?
        Figure circle = new Circle(new Point(10,300),Color.BLUE, 20);
        showFigure( circle,myWindow );

        //Un Rectángulo es una figura
        Figure rectangle = new Rectangle(new Point(100,200),Color.GREEN, 25,12);
        showFigure( rectangle, myWindow );

        Triangle triangle = new Triangle(new Point(320,240),Color.ORANGE,
                new Point(150,150), new Point(90,320));
        showFigure( triangle,myWindow );
        System.out.println( triangle.getType());

        //myWindow.getGraphics().drawPolygon(new int[]{60,120,300,280,440},new int[]{120,180,80,420,178},5);

        Integer x = 10;
        var chain = "Sogamoso";

        if ( x instanceof Integer){

        }

        if( chain instanceof String){

        }

        showObject( triangle, myWindow );

        Computer asus = new Computer("423524","Asus Zendbook",2400000);
        showObject( asus, myWindow );
    }

    static private void showFigure(Figure figure, JFrame window) {
        System.out.printf("El Area es %f\n", figure.calcArea());
        figure.drawFigure(window.getGraphics());

        if (figure instanceof Circle) {
            System.out.println("La Figura es un Circulo");
        } else if (figure instanceof Rectangle) {
            System.out.println("La Figura es un Rectangulo");
        } else {
            System.out.println("No se sabe que Figura es ");
        }

    }
    static private void showObject( ActionsFigure object, Window window ){
        System.out.println( object.calcArea());
        object.drawFigure(window.getGraphics());
    }
}
