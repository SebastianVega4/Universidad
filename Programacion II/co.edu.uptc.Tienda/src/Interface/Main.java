package Interface;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GUIstore GUIstore = new GUIstore();
        GUIstore.getFrame().setVisible(true);
        GUIstore.showLoginPanel();
    }
}