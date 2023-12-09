package View;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GUIdictionary guIdictionary = new GUIdictionary();
        guIdictionary.getFrame().setVisible(true);
        guIdictionary.showDictionaryPanel();
    }
}