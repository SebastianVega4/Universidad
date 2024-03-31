package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class panelAbout extends JFrame implements ActionListener {

    private JLabel JLAbout,JLTitle,JLTitle2,JLName1,JLName2;
    private JButton back;

    private JPanel panelPrincipal;
    private principalPanel panel;

    public panelAbout(principalPanel panel) {
        this.panel = panel;
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 380);
        setLocationRelativeTo(null);
        setTitle("About");
        setResizable(false);
        back = new JButton();
        JLAbout = new JLabel("Acerca de...");
        JLTitle = new JLabel("Taller Hilos Programacion III");
        JLTitle2 = new JLabel("Integrantes:");
        JLName1 = new JLabel(" - Julian Ricardo Diaz Ramirez");
        JLName2 = new JLabel(" - Jeimmy Patricia Valderrama Vasquez");
        panel1();
    }

    public void panel1() {

        Font letter1 = new Font("Yu Gothic Light",3,25);
        Font letter2 = new Font("Yu Gothic Light",1,20);
        Font letter3 = new Font("Yu Gothic Light",1,15);



        // Panel Principal
        panelPrincipal = new BackgroundImage("/Images/fondo.jpg");
        panelPrincipal.setBounds(0, 0, getWidth(), getHeight());
        panelPrincipal.setLayout(null);

        JLAbout.setBounds(15, 10, 200, 50);
        JLAbout.setFont(letter1);

        JLTitle.setBounds(110, 60, 400, 50);
        JLTitle.setFont(letter2);

        JLTitle2.setBounds(20, 120, 400, 50);
        JLTitle2.setFont(letter2);

        JLName1.setBounds(20, 160, 400, 50);
        JLName1.setFont(letter3);

        JLName2.setBounds(20, 200, 400, 50);
        JLName2.setFont(letter3);


        //Configuracion imagen
        try {
            BufferedImage bufferedImage4 = ImageIO.read(getClass().getResource("/Images/atras.png"));
            ImageIcon imageIcond = new ImageIcon(bufferedImage4);
            back.setBounds(20, 280, 50, 50);
            back.setBackground(new Color(248, 248, 248));
            back.setIcon(imageIcond);
            back.setBorder(null);
            back.addActionListener(this);

        } catch (IOException e1) {
            e1.printStackTrace();
        }


        panelPrincipal.add(JLAbout);
        panelPrincipal.add(JLTitle);
        panelPrincipal.add(JLTitle2);
        panelPrincipal.add(JLName1);
        panelPrincipal.add(JLName2);
        panelPrincipal.add(back);

        add(panelPrincipal);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object Componente=e.getSource();
        if(Componente.equals(back)) {
            setVisible(false);
            panel.setVisible(true);
        }
    }
}
