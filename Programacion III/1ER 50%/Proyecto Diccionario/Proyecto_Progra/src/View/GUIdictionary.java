package View;

import Model.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * Clase GUIdictionary que perimite la interaccion y el funcionamiento de la clase controller para asi darl efuncion al panel
 * que se le mostrará al usuario
 * @author Sebastian Vega y Luisa Merchan
 */
public class GUIdictionary {
    /**
     * Atributo privado de la clase GUI dictionary de tipo JFrame, este permitirá el adecuamiento del panel para mostrar al usuario
     */
    private final JFrame frame;
    /**
     * Atributo de la clase  GUIdictionary que es de tipo Controller con el cual se podrá acceder a dicha clase para acceder a sus funciones
     */
    private static Controller control;

    /**
     * Constructor de la clase GUIdictionary con el que se inicializaran los componentes del panel
     */
    public GUIdictionary(){
        frame = new JFrame("Diccionario");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(950, 680);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        control = new Controller();
    }

    /**
     * Método que mostrará el panel que se ha creado para la interaccion del usuario con el programa
     */
    public void showDictionaryPanel() {
        GUIdictionaryPanel guIdictionaryPanel = new GUIdictionaryPanel(this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(guIdictionaryPanel.getPanel(), BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    /**
     * Método que obtiene la clase de controller para su respectivo uso dentro de la GUI
     * @return control
     */

    public static Controller getControl() {
        return control;
    }

    /**
     * Método de clase JFrame que obtiene la Frame
     * @return el frame creado de la clase
     */

    public JFrame getFrame() {
        return frame;
    }
}