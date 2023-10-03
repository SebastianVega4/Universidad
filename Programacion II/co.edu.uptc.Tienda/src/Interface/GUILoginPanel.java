package Interface;

import logic.LogicCustomer;

import javax.swing.*;
import java.awt.*;

public class GUILoginPanel extends LogicCustomer {
    private final JPanel panel;

    public GUILoginPanel(GUIstore guiStore) {
        //Fondo
        panel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("Resourses\\Icons\\login.png");
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        //Panel Arriba
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);

        //logo empresa arriba a la izquierda
        ImageIcon imageLogo = new ImageIcon("Resourses\\Icons\\Logo.png");
        Image imageLog = imageLogo.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledImageLogo = new ImageIcon(imageLog);
        JLabel imgLog = new JLabel(scaledImageLogo);
        topPanel.add(imgLog, BorderLayout.WEST);//añadir imagen con ubicaion

        //boton con la imgen de admin arriba a la derecha
        ImageIcon adminIcon = new ImageIcon("Resourses\\Icons\\admin1.png");
        Image adminImage = adminIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon scaledamdinIcon = new ImageIcon(adminImage);
        JButton adminButton = new JButton("", scaledamdinIcon);
        adminButton.setOpaque(false); // Hace que el botón sea transparente
        adminButton.setContentAreaFilled(false); // Quita el relleno del botón
        adminButton.setBorderPainted(false);//no añadir borde
        adminButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//poner cursor de mano
        topPanel.add(adminButton, BorderLayout.EAST);

        // Panel Center para login
        JPanel loginPanel = new JPanel();
        loginPanel.setOpaque(false);
        loginPanel.setLayout(new GridLayout(4, 1));

        //panel grid para cada uno de los labels y field en grupos
        JPanel emailPanel = new JPanel(new GridBagLayout());
        emailPanel.setOpaque(false);
        JLabel emailLabel = new JLabel("Correo Electrónico:");
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setFont(new Font("Serif", Font.ITALIC, 18));
        JTextField emailField = new JTextField(24);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        emailPanel.add(emailLabel, gbc);
        gbc.gridy = 1;
        emailPanel.add(emailField, gbc);
        loginPanel.add(emailPanel);

        JPanel passwordPanel = new JPanel(new GridBagLayout());
        passwordPanel.setOpaque(false);
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Serif", Font.ITALIC, 18));
        JPasswordField passwordField = new JPasswordField(24);
        gbc.gridx = 0;
        gbc.gridy = 0;
        passwordPanel.add(passwordLabel, gbc);
        gbc.gridy = 1;
        passwordPanel.add(passwordField, gbc);
        loginPanel.add(passwordPanel);

        //panel de Abajo
        JPanel buttomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttomPanel.setOpaque(false);

        JButton signupButton = new JButton("Registrarse");
        signupButton.setForeground(Color.WHITE);
        signupButton.setBackground(Color.black);
        signupButton.setFont(new Font("Serif", Font.ITALIC, 11));
        signupButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttomPanel.add(signupButton);

        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(Color.black);
        loginButton.setFont(new Font("Serif", Font.ITALIC, 11));
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttomPanel.add(loginButton);

        //añadir al panel Padre Login con borde y bien ubicado
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(loginPanel, BorderLayout.CENTER);
        panel.add(buttomPanel, BorderLayout.SOUTH);

        //capturar evento del boton login
        loginButton.addActionListener(e -> {
            if (loginCustomer(emailField.getText(), new String(passwordField.getPassword()))) {
                guiStore.showCustomerMenuPanel();
            } else {
                JOptionPane.showMessageDialog(guiStore.getFrame(), "Credenciales inválidas. Inténtalo de nuevo.");
            }
        });

        //Capturar evento rsgistarse
        signupButton.addActionListener(e -> guiStore.showRegisterPanel());

        //Capturar evento boton Administrador
        adminButton.addActionListener(e -> {
            guiStore.getFrame().setVisible(false);
            new GUIadmin();
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}