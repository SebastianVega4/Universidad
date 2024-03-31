package View;

import Model.Player;
import View.BackgroundImage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class panelWiners extends JFrame implements ActionListener {

    private JLabel JLWiners, JL1, JL2, JL3, JL4, JL5;
    private JButton next, exit;

    private JPanel panelPrincipal;
    private principalPanel panel;

    private JLabel imgWinner, img2, img3, img4, img5;

    private JLabel score, s1, s2, s3, s4, s5;

    public panelWiners(principalPanel panel) {
        this.panel = panel;
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 630);
        setLocationRelativeTo(null);
        setTitle("Winners");
        setResizable(false);
        next = new JButton("Siguiente Partida");
        exit = new JButton("SAlIR");
        JLWiners = new JLabel("Resultados");
        JL1 = new JLabel();
        JL2 = new JLabel();
        JL3 = new JLabel();
        JL4 = new JLabel();
        JL5 = new JLabel();
        imgWinner = new JLabel();
        img2 = new JLabel();
        img3 = new JLabel();
        img4 = new JLabel();
        img5 = new JLabel();

        score = new JLabel("Puntaje");
        s1 = new JLabel();
        s2 = new JLabel();
        s3 = new JLabel();
        s4 = new JLabel();
        s5 = new JLabel();

        next.addActionListener(this);
        exit.addActionListener(this);
    }

    public void panel1(List<Player> players) {
        panelPrincipal = new BackgroundImage("/Images/fondo.jpg");
        panelPrincipal.setBounds(0, 0, getWidth(), getHeight());
        panelPrincipal.setLayout(null);

         // Eliminar todos los componentes previamente agregados al panel

        Font letter1 = new Font("Yu Gothic Light", 3, 25);
        Font letter2 = new Font("Yu Gothic Light", 1, 20);
        Font letter3 = new Font("Yu Gothic Light", 1, 15);

        List<Player> playerWin = players.stream()
                .sorted(Comparator.comparingLong(Player::getTime))
                .collect(Collectors.toList());

        int[] coinAmounts = {50, 40, 30, 20, 10};

        s1.setText(String.valueOf(coinAmounts[0]));
        s2.setText(String.valueOf(coinAmounts[1]));
        s3.setText(String.valueOf(coinAmounts[2]));
        s4.setText(String.valueOf(coinAmounts[3]));
        s5.setText(String.valueOf(coinAmounts[4]));

        JLWiners.setText("Resultados");
        JLWiners.setBounds(15, 10, 200, 50);
        JLWiners.setFont(letter1);
        JLWiners.setVisible(true);

        JL1.setText(playerWin.get(0).getName());
        JL1.setBounds(165, 80, 400, 50);
        JL1.setFont(letter2);
        JL1.setVisible(true);

        JL2.setText(playerWin.get(1).getName());
        JL2.setBounds(175, 150, 400, 50);
        JL2.setFont(letter3);
        JL2.setVisible(true);

        JL3.setText(playerWin.get(2).getName());
        JL3.setBounds(175, 230, 400, 50);
        JL3.setFont(letter3);
        JL3.setVisible(true);

        JL4.setText(playerWin.get(3).getName());
        JL4.setBounds(175, 310, 400, 50);
        JL4.setFont(letter3);
        JL4.setVisible(true);

        JL5.setText(playerWin.get(4).getName());
        JL5.setBounds(175, 390, 400, 50);
        JL5.setFont(letter3);
        JL5.setVisible(true);

        score.setText("Puntaje");
        score.setBounds(340, 40, 400, 50);
        score.setFont(letter2);


        s1.setBounds(350, 80, 400, 50);
        s1.setFont(letter2);


        s2.setBounds(355, 150, 400, 50);
        s2.setFont(letter3);


        s3.setBounds(355, 230, 400, 50);
        s3.setFont(letter3);


        s4.setBounds(355, 310, 400, 50);
        s4.setFont(letter3);


        s5.setBounds(355, 390, 400, 50);
        s5.setFont(letter3);

        next.setBounds(150, 480, 200, 50);
        next.setBackground(new Color(255, 250, 250));
        next.setBorder(BorderFactory.createLineBorder(Color.gray, 10));
        next.setFont(letter2);

        try {
            BufferedImage bufferedImage1 = ImageIO.read(getClass().getResource("/Images/corona.png"));
            ImageIcon imageIcon1 = new ImageIcon(bufferedImage1);
            imgWinner.setBounds(85, 65, 65, 50);
            imgWinner.setBackground(new Color(248, 248, 248));
            imgWinner.setIcon(imageIcon1);
            imgWinner.setBorder(null);

            BufferedImage bufferedImage2 = ImageIO.read(getClass().getResource("/Images/2.png"));
            ImageIcon imageIcon2 = new ImageIcon(bufferedImage2);
            img2.setBounds(110, 145, 50, 50);
            img2.setBackground(new Color(248, 248, 248));
            img2.setIcon(imageIcon2);
            img2.setBorder(null);

            BufferedImage bufferedImage3 = ImageIO.read(getClass().getResource("/Images/3.png"));
            ImageIcon imageIcon3 = new ImageIcon(bufferedImage3);
            img3.setBounds(110, 225, 50, 50);
            img3.setBackground(new Color(248, 248, 248));
            img3.setIcon(imageIcon3);
            img3.setBorder(null);

            BufferedImage bufferedImage4 = ImageIO.read(getClass().getResource("/Images/4.png"));
            ImageIcon imageIcon4 = new ImageIcon(bufferedImage4);
            img4.setBounds(110, 305, 50, 50);
            img4.setBackground(new Color(248, 248, 248));
            img4.setIcon(imageIcon4);
            img4.setBorder(null);

            BufferedImage bufferedImage5 = ImageIO.read(getClass().getResource("/Images/5.png"));
            ImageIcon imageIcon5 = new ImageIcon(bufferedImage5);
            img5.setBounds(110, 385, 50, 50);
            img5.setBackground(new Color(248, 248, 248));
            img5.setIcon(imageIcon5);
            img5.setBorder(null);

        } catch (IOException e1) {
            e1.printStackTrace();
        }

        panelPrincipal.removeAll();
        panelPrincipal.add(JLWiners);
        panelPrincipal.add(JL1);
        panelPrincipal.add(JL2);
        panelPrincipal.add(JL3);
        panelPrincipal.add(JL4);
        panelPrincipal.add(JL5);
        panelPrincipal.add(imgWinner);
        panelPrincipal.add(img2);
        panelPrincipal.add(img3);
        panelPrincipal.add(img4);
        panelPrincipal.add(img5);
        panelPrincipal.add(score);
        panelPrincipal.add(s1);
        panelPrincipal.add(s2);
        panelPrincipal.add(s3);
        panelPrincipal.add(s4);
        panelPrincipal.add(s5);
        panelPrincipal.add(next);


        add(panelPrincipal);

        JL1.setVisible(true);

        setVisible(true);
    }

    public void finalPanel(List<Player> players){

        panelPrincipal = new BackgroundImage("/Images/fondo.jpg");
        panelPrincipal.setBounds(0, 0, getWidth(), getHeight());
        panelPrincipal.setLayout(null);


        Font letter1 = new Font("Yu Gothic Light", 3, 25);
        Font letter2 = new Font("Yu Gothic Light", 1, 20);
        Font letter3 = new Font("Yu Gothic Light", 1, 15);

        List<Player> playerWin = players.stream()
                .sorted(Comparator.comparingLong(Player::getCoins).reversed())
                .collect(Collectors.toList());


        s1.setText(String.valueOf(playerWin.get(0).getCoins()));
        s2.setText(String.valueOf(playerWin.get(1).getCoins()));
        s3.setText(String.valueOf(playerWin.get(2).getCoins()));
        s4.setText(String.valueOf(playerWin.get(3).getCoins()));
        s5.setText(String.valueOf(playerWin.get(4).getCoins()));

        JLWiners.setText("Resultados");
        JLWiners.setBounds(15, 10, 200, 50);
        JLWiners.setFont(letter1);
        JLWiners.setVisible(true);

        JL1.setText(playerWin.get(0).getName());
        JL1.setBounds(165, 80, 400, 50);
        JL1.setFont(letter2);
        JL1.setVisible(true);

        JL2.setText(playerWin.get(1).getName());
        JL2.setBounds(175, 150, 400, 50);
        JL2.setFont(letter3);
        JL2.setVisible(true);

        JL3.setText(playerWin.get(2).getName());
        JL3.setBounds(175, 230, 400, 50);
        JL3.setFont(letter3);
        JL3.setVisible(true);

        JL4.setText(playerWin.get(3).getName());
        JL4.setBounds(175, 310, 400, 50);
        JL4.setFont(letter3);
        JL4.setVisible(true);

        JL5.setText(playerWin.get(4).getName());
        JL5.setBounds(175, 390, 400, 50);
        JL5.setFont(letter3);
        JL5.setVisible(true);

        score.setText("Puntaje");
        score.setBounds(340, 40, 400, 50);
        score.setFont(letter2);


        s1.setBounds(350, 80, 400, 50);
        s1.setFont(letter2);


        s2.setBounds(355, 150, 400, 50);
        s2.setFont(letter3);


        s3.setBounds(355, 230, 400, 50);
        s3.setFont(letter3);


        s4.setBounds(355, 310, 400, 50);
        s4.setFont(letter3);


        s5.setBounds(355, 390, 400, 50);
        s5.setFont(letter3);

        exit.setBounds(150, 480, 200, 50);
        exit.setBackground(new Color(255, 250, 250));
        exit.setBorder(BorderFactory.createLineBorder(Color.gray, 10));
        exit.setFont(letter2);

        try {
            BufferedImage bufferedImage1 = ImageIO.read(getClass().getResource("/Images/corona.png"));
            ImageIcon imageIcon1 = new ImageIcon(bufferedImage1);
            imgWinner.setBounds(85, 65, 65, 50);
            imgWinner.setBackground(new Color(248, 248, 248));
            imgWinner.setIcon(imageIcon1);
            imgWinner.setBorder(null);

            BufferedImage bufferedImage2 = ImageIO.read(getClass().getResource("/Images/2.png"));
            ImageIcon imageIcon2 = new ImageIcon(bufferedImage2);
            img2.setBounds(110, 145, 50, 50);
            img2.setBackground(new Color(248, 248, 248));
            img2.setIcon(imageIcon2);
            img2.setBorder(null);

            BufferedImage bufferedImage3 = ImageIO.read(getClass().getResource("/Images/3.png"));
            ImageIcon imageIcon3 = new ImageIcon(bufferedImage3);
            img3.setBounds(110, 225, 50, 50);
            img3.setBackground(new Color(248, 248, 248));
            img3.setIcon(imageIcon3);
            img3.setBorder(null);

            BufferedImage bufferedImage4 = ImageIO.read(getClass().getResource("/Images/4.png"));
            ImageIcon imageIcon4 = new ImageIcon(bufferedImage4);
            img4.setBounds(110, 305, 50, 50);
            img4.setBackground(new Color(248, 248, 248));
            img4.setIcon(imageIcon4);
            img4.setBorder(null);

            BufferedImage bufferedImage5 = ImageIO.read(getClass().getResource("/Images/5.png"));
            ImageIcon imageIcon5 = new ImageIcon(bufferedImage5);
            img5.setBounds(110, 385, 50, 50);
            img5.setBackground(new Color(248, 248, 248));
            img5.setIcon(imageIcon5);
            img5.setBorder(null);

        } catch (IOException e1) {
            e1.printStackTrace();
        }

        panelPrincipal.add(JLWiners);
        panelPrincipal.add(JL1);
        panelPrincipal.add(JL2);
        panelPrincipal.add(JL3);
        panelPrincipal.add(JL4);
        panelPrincipal.add(JL5);
        panelPrincipal.add(imgWinner);
        panelPrincipal.add(img2);
        panelPrincipal.add(img3);
        panelPrincipal.add(img4);
        panelPrincipal.add(img5);
        panelPrincipal.add(score);
        panelPrincipal.add(s1);
        panelPrincipal.add(s2);
        panelPrincipal.add(s3);
        panelPrincipal.add(s4);
        panelPrincipal.add(s5);
        panelPrincipal.add(exit);

        add(panelPrincipal);

        JL1.setVisible(true);

        setVisible(true);

    }

    public JButton getExit() {
        return exit;
    }

    public JButton getNext() {
        return next;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object Componente = e.getSource();
        if (Componente.equals(next)) {
            setVisible(false);
            panel.uploadGame();
            panel.setVisible(true);
        }
        if(Componente.equals(exit)){
            System.exit(0);
        }
    }

}
