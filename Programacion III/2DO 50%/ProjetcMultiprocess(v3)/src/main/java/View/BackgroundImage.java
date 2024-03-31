package View;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


/**
 * Clase personalizada que extiende JPanel y permite establecer una imagen de fondo en un panel.
 */

public class BackgroundImage extends JPanel {
	
	private Image imagen;
	private String ruta;
	
    /**
     * Constructor de la clase backgroundImage.
     *
     * @param ruta La ruta de la imagen que se utilizar� como fondo del panel.
     */
	
	public BackgroundImage(String ruta) {
		super();
		this.ruta = ruta;
	}

    /**
     * M�todo para pintar la imagen de fondo en el panel.
     *
     * @param g El objeto Graphics utilizado para el dibujo.
     */
	
	public void paint(Graphics g) {
		
		imagen = new ImageIcon(getClass().getResource(ruta)).getImage();
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(),this);
		setOpaque(false);
		super.paint(g);
		
	}

}
