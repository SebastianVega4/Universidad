package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

/**
 * Clase Border personalizada que implementa javax.swing.border.Border.
 * Esta clase se utiliza para dibujar un borde redondeado alrededor de un componente Swing.
 */
public class Border implements javax.swing.border.Border{

    private int radius;
    private Color color;
    
    Border(int radius, Color Color) {
        this.radius = radius;
        this.color = Color;
    }

	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		  Graphics2D g2=(Graphics2D) g;
		  g2.setColor(color);

		  //Esto mejora (alisa) es aspecto de renderizado del borde
		  g2.setRenderingHints(new RenderingHints(
		                       RenderingHints.KEY_ANTIALIASING,
		                       RenderingHints.VALUE_ANTIALIAS_ON));
		  
		  g2.drawRoundRect(x+1,y+1,width-3,height-3,radius,radius);
		
	}
	
	public boolean isBorderOpaque() {
		return false;
	}
	
	public Insets getBorderInsets(Component c) {
		return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
	
	}


}
