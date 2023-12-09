package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class GUIdictionaryPanel {
    private final JPanel panel;

    public GUIdictionaryPanel(GUIdictionary guIdictionary) {
        panel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("wallpaper.png");
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        //Panel Arriba
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);

        //logo empresa arriba a la izquierda
        ImageIcon imageLogo = new ImageIcon("logo.png");
        Image imageLog = imageLogo.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledImageLogo = new ImageIcon(imageLog);
        JLabel imgLog = new JLabel(scaledImageLogo);
        topPanel.add(imgLog, BorderLayout.WEST);

        // Panel Center para Mostrar Texto
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerPanel.setOpaque(false);

        //textt
        JPanel textPanel = new JPanel(new GridBagLayout());
        textPanel.setOpaque(false);
        JTextArea jtxaLista = new JTextArea();
        jtxaLista.setLineWrap(true);
        jtxaLista.setWrapStyleWord(true);
        JScrollPane scrollPaneltext = new JScrollPane(jtxaLista);
        scrollPaneltext.setPreferredSize(new Dimension(400, 400));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        textPanel.add(scrollPaneltext, gbc);
        centerPanel.add(textPanel);

        JPanel consultPanel = new JPanel(new GridBagLayout());
        consultPanel.setOpaque(false);
        JLabel wordLabel = new JLabel("Palabra:");
        wordLabel.setForeground(Color.black);
        wordLabel.setFont(new Font("Serif", Font.ITALIC, 18));
        JTextField wordField = new JTextField(24);
        JLabel meaningLabel = new JLabel("Significado:");
        meaningLabel.setForeground(Color.black);
        meaningLabel.setFont(new Font("Serif", Font.ITALIC, 18));
        JTextField meaningField = new JTextField(24);
        JLabel translationLabel = new JLabel("Traduccion:");
        translationLabel.setForeground(Color.black);
        translationLabel.setFont(new Font("Serif", Font.ITALIC, 18));
        JTextField translationField = new JTextField(24);
        gbc.gridx = 1;
        gbc.gridy =0;
        consultPanel.add(wordLabel,gbc);
        gbc.gridy++;
        consultPanel.add(wordField,gbc);
        gbc.gridy++;
        consultPanel.add(meaningLabel,gbc);
        gbc.gridy++;
        consultPanel.add(meaningField,gbc);
        gbc.gridy++;
        consultPanel.add(translationLabel,gbc);
        gbc.gridy++;
        consultPanel.add(translationField,gbc);
        centerPanel.add(consultPanel);

        //panel de Abajo
        JPanel buttomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttomPanel.setOpaque(false);

        JButton addButton = new JButton("Agregar");
        addButton.setForeground(Color.WHITE);
        addButton.setBackground(Color.black);
        addButton.setFont(new Font("Serif", Font.ITALIC, 11));
        addButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttomPanel.add(addButton);

        JButton consultButton = new JButton("Consultar");
        consultButton.setForeground(Color.WHITE);
        consultButton.setBackground(Color.black);
        consultButton.setFont(new Font("Serif", Font.ITALIC, 11));
        consultButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttomPanel.add(consultButton);

        JButton deleteButton = new JButton("Eliminar");
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setBackground(Color.black);
        deleteButton.setFont(new Font("Serif", Font.ITALIC, 11));
        deleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttomPanel.add(deleteButton);

        JButton modificButton = new JButton("Modificar");
        modificButton.setForeground(Color.WHITE);
        modificButton.setBackground(Color.black);
        modificButton.setFont(new Font("Serif", Font.ITALIC, 11));
        modificButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttomPanel.add(modificButton);

        JButton exitButton = new JButton("Salir");
        exitButton.setForeground(Color.WHITE);
        exitButton.setBackground(Color.black);
        exitButton.setFont(new Font("Serif", Font.ITALIC, 11));
        exitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttomPanel.add(exitButton);

        //añadir al panel
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 50, 20));
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(buttomPanel, BorderLayout.SOUTH);


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Objects.equals(wordField.getText(), "") && !Objects.equals(meaningField.getText(), "") && !Objects.equals(translationField.getText(), "")){
                    String word = wordField.getText();
                    String meaning = meaningField.getText();
                    String translation = translationField.getText();
                    JOptionPane.showMessageDialog(null, guIdictionary.getControl().addWord(word, meaning, translation));
                    wordField.setText("");
                    meaningField.setText("");
                    translationField.setText("");
                    jtxaLista.setText("");
                    jtxaLista.append(guIdictionary.getControl().showAllWords());
                }else {
                    JOptionPane.showMessageDialog(null,"Nigun campo debe estar vacio");
                }
            }
        });
        modificButton.addActionListener(new ActionListener() {
            int cont=0;
            @Override
            public void actionPerformed(ActionEvent e) {
                cont++;
                if (cont == 1) {
                    String word = JOptionPane.showInputDialog("Digite la palabra que desea modificar");
                    if (!Objects.equals(word, "")) {
                        if (guIdictionary.getControl().showIfExistWord(word)) {
                            wordField.setText(word);
                            meaningField.setText(guIdictionary.getControl().showMeaning(word));
                            translationField.setText(guIdictionary.getControl().showTranslation(word));
                            addButton.setVisible(false);
                            consultButton.setVisible(false);
                            deleteButton.setVisible(false);
                            wordField.setEditable(false);
                            cont = cont + 1;
                        } else {
                            JOptionPane.showMessageDialog(null, "La palabra no existe");
                            cont = 0;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El campo no puede estar vacio");
                        cont = 0;
                    }
                } else {
                    if (!Objects.equals(wordField.getText(), "") && !Objects.equals(meaningField.getText(), "") && !Objects.equals(translationField.getText(), "")) {
                        guIdictionary.getControl().modifyWord(wordField.getText(), meaningField.getText(), translationField.getText());
                        wordField.setEditable(true);
                        wordField.setText("");
                        meaningField.setText("");
                        translationField.setText("");
                        addButton.setVisible(true);
                        consultButton.setVisible(true);
                        deleteButton.setVisible(true);
                        cont = 0;
                    } else {
                        JOptionPane.showMessageDialog(null, "Ningun campo puede estar vacio");
                    }
                }
                jtxaLista.setText("");
                jtxaLista.append(guIdictionary.getControl().showAllWords());
            }
        });

        deleteButton.addActionListener(e -> {
            String word = JOptionPane.showInputDialog("Digite la palabra que desea eliminar");
            if (!Objects.equals(word, "")) {
                if (guIdictionary.getControl().showIfExistWord(word)) {
                    guIdictionary.getControl().deleteWord(word);
                    JOptionPane.showMessageDialog(null, "La palabra: " + word + " fue eliminada");
                } else {
                    JOptionPane.showMessageDialog(null, "La palabra no existe");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El campo no puede ser vacio");
            }
            jtxaLista.setText("");
            jtxaLista.append(guIdictionary.getControl().showAllWords());
        });

        exitButton.addActionListener(e -> System.exit(0));

        consultButton.addActionListener(e -> {
            int a = JOptionPane.showOptionDialog(null, "Eligue la opcion que desea", "Atencion",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    new Object[]{"Dictionary completo", "Listado por Letra", "Palabra"}, "Opcion");
            jtxaLista.setText("");
            switch (a) {
                case 0 -> jtxaLista.append(guIdictionary.getControl().showAllWords());
                case 1 -> {
                    String word = JOptionPane.showInputDialog("digite la letra que desea consultar");
                    if (word.length() != 1) {
                        JOptionPane.showMessageDialog(null, "Digite solo un caracter");
                    } else {
                        jtxaLista.append("\nletra : "+ guIdictionary.getControl().firstLetterWithMayus(word) +"\n"+guIdictionary.getControl().showForLatter(word));
                    }
                }
                case 2 -> {
                    String word2 = JOptionPane.showInputDialog("Digite la palabras que desea consultar");
                    if (word2.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "El valor no puede ser nulo");
                    } else {
                        jtxaLista.append(guIdictionary.getControl().consult(word2));
                    }
                }
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}