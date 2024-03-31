package View;
import javax.swing.*;
import java.awt.*;

/**
 * Clase RoundedPanel que extiende JPanel para crear un panel con esquinas redondeadas.
 */
public class RoundedPanel extends JPanel {
	
	private int cornerRadius;
	private Color color;

    /**
     * Constructor de la clase RoundedPanel.
     *
     * @param cornerRadius El radio de las esquinas redondeadas del panel.
     * @param color        El color del panel.
     */
    public RoundedPanel(int cornerRadius,Color color) {
        this.cornerRadius = cornerRadius;
        this.color = color;
        setOpaque(false);
    }
    
    /**
     * M�todo que se llama para pintar el componente.
     *
     * @param g El objeto Graphics utilizado para pintar el componente.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(cornerRadius, cornerRadius);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(getBackground());
        graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
        graphics.setColor(color);
        graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
    }
}