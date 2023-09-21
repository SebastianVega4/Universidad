package Logic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Email extends JFrame {
    private final JTextField destinatarioField;
    private final JTextField asuntoField;
    private final JTextArea cuerpoTextArea;

    public Email() {
        setTitle("Mensaje nuevo");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(Color.WHITE);
        infoPanel.setLayout(new GridLayout(2, 2));

        JLabel destinatarioLabel = new JLabel("Para:");
        destinatarioField = new JTextField(30);
        destinatarioField.setBorder(null);
        JLabel asuntoLabel = new JLabel("Asunto:");
        asuntoField = new JTextField(30);
        asuntoField.setBorder(null);
        JLabel cuerpoLabel = new JLabel("Cuerpo:");
        cuerpoTextArea = new JTextArea(10, 40);
        cuerpoTextArea.setBorder(null);
        JScrollPane scrollPane = new JScrollPane(cuerpoTextArea);
        scrollPane.setBorder(null);
        infoPanel.add(destinatarioLabel);
        infoPanel.add(destinatarioField);
        infoPanel.add(asuntoLabel);
        infoPanel.add(asuntoField);
        infoPanel.add(cuerpoLabel);
        infoPanel.add(scrollPane);
        JButton enviarButton = new JButton("Enviar");
        enviarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String destinatario = destinatarioField.getText();
                String asunto = asuntoField.getText();
                String cuerpo = cuerpoTextArea.getText();


                // Aquí puedes implementar la lógica para enviar el correo electrónico
                // Puedes usar una librería como JavaMail para enviar el correo.
                JOptionPane.showMessageDialog(null, "Email enviado a: " + destinatario);
            }
        });
        panel.add(infoPanel, BorderLayout.CENTER);
        panel.add(enviarButton, BorderLayout.SOUTH);
        add(panel);
    }
}