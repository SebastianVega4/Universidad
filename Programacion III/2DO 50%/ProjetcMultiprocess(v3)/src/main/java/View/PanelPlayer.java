package View;

import Controller.ControllerPlayer;
import Controller.RunnableDices;
import Controller.RunnableTime;
import Model.Player;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

public class PanelPlayer {

    private int lanzamientos;
    private Player player;
    private int totalLanzamientos;
    private ImageIcon[] diceImages;
    private Timer timer,timer2;
    private JPanel panelPrincipal;
    private JLabel time, time1, name, name1, itemNumber, itemNumber1, launch, launch1, launchScore, launchScore1,
            sumScore, sumScore1, remaining, remaining1, dice1, dice11, dice2, dice22;



    public PanelPlayer(Player player) {
        this.player = player;
        lanzamientos = 0;
        totalLanzamientos = 0;
        panelPrincipal = new JPanel();
        time = new JLabel("Horario: ");
        time1 = new JLabel();
        name = new JLabel("Jugador: ");
        name1 = new JLabel();
        itemNumber = new JLabel("Partida N° ");
        itemNumber1 = new JLabel();
        launch = new JLabel("Partidas restantes: ");
        launch1 = new JLabel();
        launchScore = new JLabel("Puntuación lanzamiento: ");
        launchScore1 = new JLabel();
        sumScore = new JLabel("Puntuación total: ");
        sumScore1 = new JLabel();
        remaining = new JLabel("Puntuación restante: ");
        remaining1 = new JLabel("--");
        dice1 = new JLabel("Dado 1");
        dice11 = new JLabel();
        dice2 = new JLabel("Dado 2");
        dice22 = new JLabel();
        loadDiceImages();
    }

    public void startThreads() {
        player.setNumberGamePlayer(player.getNumberGamePlayer() + 1);
        itemNumber1.setText(String.valueOf(player.getNumberGamePlayer()));

        timer = new Timer(1000, e -> {
            name1.setText(player.getName());
            time1.setText(player.getCurrentTime());

        });


        timer2 = new Timer(player.getWaitingTime(), e -> {
            dice11.setIcon(diceImages[player.getDiceOne().getNumber()]);
            dice22.setIcon(diceImages[player.getDiceTwo().getNumber()]);
            int resultadoDado1 = player.getDiceOne().getNumber();
            int resultadoDado2 = player.getDiceTwo().getNumber();
            int resultadoTotal = resultadoDado1 + resultadoDado2;

            launchScore1.setText("" + resultadoTotal);
            sumScore1.setText(""+player.getPoints());

            launch1.setText(String.valueOf(player.getNumberGames()));

            int restante = player.getPointsToComplete() - player.getPoints();
            if (restante > 0){
                remaining1.setText(""+restante);
            }else if(restante <=0){
                remaining1.setText("0");
            }


        });


        timer.start();
        timer2.start();
    }

    public void stopThread(){
//        timer.stop();
//        timer2.stop();
    }



    public JPanel panel(int x, int y) {

        Font letter1 = new Font("Yu Gothic Light", 1, 15);
        Font letter2 = new Font("Yu Gothic Light", 1, 25);
        //Panel Principal
        panelPrincipal = new RoundedPanel(20, Color.darkGray);
        panelPrincipal.setBackground(new Color(248, 248, 248));
        panelPrincipal.setBounds(x, y, 425, 370);
        panelPrincipal.setLayout(null);

        name.setBounds(30, 10, 200, 25);
        name.setFont(letter1);
        name1.setBounds(150, 10, 250, 25);
        name1.setFont(letter1);
        time.setBounds(30, 30, 150, 25);
        time.setFont(letter1);
        time1.setBounds(150, 30, 250, 25);
        time1.setFont(letter1);
        dice1.setBounds(100, 210, 150, 25);
        dice1.setFont(letter1);
        dice11.setBounds(60, 60, 150, 150);
        dice11.setFont(letter2);
        dice2.setBounds(270, 210, 150, 25);
        dice2.setFont(letter1);
        dice22.setBounds(230, 60, 150, 150);
        dice22.setFont(letter2);
        itemNumber.setBounds(30, 250, 150, 25);
        itemNumber.setFont(letter1);
        itemNumber1.setBounds(100, 250, 150, 25);
        itemNumber1.setFont(letter1);
        launch.setBounds(30, 270, 150, 25);
        launch.setFont(letter1);
        launch1.setBounds(165, 270, 150, 25);
        launch1.setFont(letter1);
        launchScore.setBounds(30, 290, 180, 25);
        launchScore.setFont(letter1);
        launchScore1.setBounds(210, 290, 180, 25);
        launchScore1.setFont(letter1);
        sumScore.setBounds(30, 310, 130, 25);
        sumScore.setFont(letter1);
        sumScore1.setBounds(155, 310, 150, 25);
        sumScore1.setFont(letter1);
        remaining.setBounds(30, 330, 150, 25);
        remaining.setFont(letter1);
        remaining1.setBounds(180, 330, 150, 25);
        remaining1.setFont(letter1);

        panelPrincipal.add(time);
        panelPrincipal.add(time1);
        panelPrincipal.add(name);
        panelPrincipal.add(name1);
        panelPrincipal.add(itemNumber);
        panelPrincipal.add(itemNumber1);
        panelPrincipal.add(launch);
        panelPrincipal.add(launch1);
        panelPrincipal.add(launchScore);
        panelPrincipal.add(launchScore1);
        panelPrincipal.add(sumScore);
        panelPrincipal.add(sumScore1);
        panelPrincipal.add(remaining);
        panelPrincipal.add(remaining1);
        panelPrincipal.add(dice1);
        panelPrincipal.add(dice11);
        panelPrincipal.add(dice2);
        panelPrincipal.add(dice22);
        return panelPrincipal;

    }

    private void loadDiceImages() {
        diceImages = new ImageIcon[7];
        for (int i = 1; i <= 6; i++) {
            try {
                BufferedImage img = ImageIO.read(getClass().getResource("/Images/dice_" + i + ".png"));
                diceImages[i] = new ImageIcon(img);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




    public int getTotalLanzamientos() {
        return totalLanzamientos;
    }

    public int getLanzamientos() {
        return lanzamientos;
    }


}