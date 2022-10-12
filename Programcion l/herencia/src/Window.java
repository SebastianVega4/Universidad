import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window(String title)  {
        super(title);
        setSize( new Dimension(640,480));
        setDefaultCloseOperation( EXIT_ON_CLOSE );
    }
}
