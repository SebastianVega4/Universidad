package Interface;

import logic.LogicCustomer;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GUIRegisterPanel extends LogicCustomer {
    private final JPanel panel;

    public GUIRegisterPanel(GUIstore guiStore) {
        panel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("Resourses\\Icons\\SignUp.png");
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);

        ImageIcon imageLogo = new ImageIcon("Resourses\\Icons\\Logo.png");
        Image imageLog = imageLogo.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledImageLogo = new ImageIcon(imageLog);
        JLabel imgLog = new JLabel(scaledImageLogo);
        topPanel.add(imgLog, BorderLayout.WEST);

        JPanel signUpPanel = new JPanel();
        signUpPanel.setOpaque(false);
        signUpPanel.setLayout(new GridLayout(4, 1));

        JPanel namePanel = new JPanel(new GridBagLayout());
        namePanel.setOpaque(false);
        JLabel nameLabel = new JLabel("Nombre:");
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Serif", Font.ITALIC, 18));
        JTextField nameField = new JTextField(24);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        namePanel.add(nameLabel, gbc);
        gbc.gridy = 1;
        namePanel.add(nameField,gbc);
        signUpPanel.add(namePanel);

        JPanel emailPanel = new JPanel(new GridBagLayout());
        emailPanel.setOpaque(false);
        JLabel emailLabel = new JLabel("Correo Electrónico:");
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setFont(new Font("Serif", Font.ITALIC, 18));
        JTextField emailField = new JTextField(24);
        gbc.gridx = 0;
        gbc.gridy = 0;
        emailPanel.add(emailLabel,gbc);
        gbc.gridy = 1;
        emailPanel.add(emailField,gbc);
        signUpPanel.add(emailPanel);

        JPanel passwordPanel = new JPanel(new GridBagLayout());
        passwordPanel.setOpaque(false);
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Serif", Font.ITALIC, 18));
        JPasswordField passwordField = new JPasswordField(24);
        gbc.gridx = 0;
        gbc.gridy = 0;
        passwordPanel.add(passwordLabel,gbc);
        gbc.gridy = 1;
        passwordPanel.add(passwordField,gbc);
        signUpPanel.add(passwordPanel);

        JPanel buttomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttomPanel.setOpaque(false);

        JButton backButton = new JButton("Atrás");
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.black);
        backButton.setFont(new Font("Serif", Font.ITALIC, 11));
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttomPanel.add(backButton);

        JButton signinButton = new JButton("Registrarse");
        signinButton.setForeground(Color.WHITE);
        signinButton.setBackground(Color.black);
        signinButton.setFont(new Font("Serif", Font.ITALIC, 11));
        signinButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttomPanel.add(signinButton);

        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(signUpPanel, BorderLayout.CENTER);
        panel.add(buttomPanel, BorderLayout.PAGE_END);

        signinButton.addActionListener(e -> {
            if (!Objects.equals(nameField.getText(), "") && !Objects.equals(emailField.getText(), "")) {
                Pattern parametros = Pattern.compile("^([A-Za-z0-9_.-]+@[0-9a-zA-Z]+[.][a-z]{3})([.][a-z]{2})?$");
                Matcher validar = parametros.matcher(emailField.getText());
                if (validar.find()) {
                    User newUser = new User(nameField.getText(), emailField.getText(), passwordField.getText(), null);
                    GUIstore.getCustomers().addUser(newUser);
                    JOptionPane.showMessageDialog(guiStore.getFrame(), signinCustomer());
                } else JOptionPane.showMessageDialog(guiStore.getFrame(),"El email ingresado *NO* es valido \n" +
                        "@Dominio.Extencion ");
            } else JOptionPane.showMessageDialog(guiStore.getFrame(),"ERROR: Campos en blanco");
        });
        backButton.addActionListener(e -> guiStore.showLoginPanel());
    }

    public JPanel getPanel() {
        return panel;
    }
}