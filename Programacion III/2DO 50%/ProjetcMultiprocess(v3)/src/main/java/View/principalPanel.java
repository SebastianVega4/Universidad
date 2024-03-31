package View;

import Controller.ControllerPlayer;
import Controller.RunnableDices;
import Controller.RunnableTime;
import Model.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class principalPanel extends JFrame {
    private JPanel panelPrincipal;
    private panelAbout panelAbout;
    private boolean flag = false;

    private panelWiners panelWiners;

    private JLabel control,imgIni;
    private JButton start, about, iniciarHilosButton, detenerHilosButton, reiniciarHilosButton;
    private List<PanelPlayer> jugadores = new ArrayList<>();
    private ControllerPlayer controllerPlayer = new ControllerPlayer();
    panelWiners panelWiners1;

    List<Player> players;

    RunnableTime runnableTime1;
    RunnableTime runnableTime2;
    RunnableTime runnableTime3;
    RunnableTime runnableTime4;
    RunnableTime runnableTime5;

    RunnableDices runnableDices1;
    RunnableDices runnableDices2;
    RunnableDices runnableDices3;
    RunnableDices runnableDices4;
    RunnableDices runnableDices5;

    Thread th1;
    Thread th2;
    Thread th3;
    Thread th4;
    Thread th5;
    Thread th6;
    Thread th7;
    Thread th8;
    Thread th9;
    Thread th10;

    Thread[] threads = {th1, th2, th3, th4, th5};
    long[] startTimes = new long[threads.length];

    public principalPanel() {

        controllerPlayer.initialisePlayers();
        players = controllerPlayer.getPlayers();
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 820);
        setLocationRelativeTo(null);
        setTitle("Hilos");
        setResizable(false);

        control = new JLabel("Zona de control");
        imgIni = new JLabel();

        panelAbout = new panelAbout(this);
        panelAbout.setVisible(false);

        panelWiners = new panelWiners(this);
        panelWiners.setVisible(false);

        runnableTime1 = new RunnableTime(players.get(0));
        runnableTime2 = new RunnableTime(players.get(1));
        runnableTime3 = new RunnableTime(players.get(2));
        runnableTime4 = new RunnableTime(players.get(3));
        runnableTime5 = new RunnableTime(players.get(4));

        th6 = new Thread(runnableTime1);
        th7 = new Thread(runnableTime2);
        th8 = new Thread(runnableTime3);
        th9 = new Thread(runnableTime4);
        th10 = new Thread(runnableTime5);


    }

    public void principal() {

        // Otras fuentes
        Font letter2 = new Font("Yu Gothic Light", 3, 25);

        control.setFont(letter2);
        control.setBounds(1070, 400,200,50);
        control.setVisible(false);

        // Configuracion Paneles
        // Panel Principal
        panelPrincipal = new BackgroundImage("/Images/fondo.jpg");
        panelPrincipal.setBounds(0, 0, getWidth(), getHeight());
        panelPrincipal.setLayout(null);

        about = new JButton("About");
        about.setBounds(1111, 590, 100, 60);
        about.setBackground(new Color(255, 250, 250));
        about.setBorder(new Border(10, Color.gray));
        about.setFont(letter2);


        try {
            BufferedImage bufferedImage1 = ImageIO.read(getClass().getResource("/Images/img1.png"));
            ImageIcon imageIcon1 = new ImageIcon(bufferedImage1);
            imgIni.setBounds(15, 10, 1200, 400);
            imgIni.setBackground(new Color(248, 248, 248));
            imgIni.setIcon(imageIcon1);
            imgIni.setBorder(null);
            imgIni.setVisible(true);

        } catch (IOException e1) {
            e1.printStackTrace();
        }

        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == about) {
                    setVisible(false);
                    panelAbout.setVisible(true);
                }

            }
        });

        start = new JButton("Start");
        start.setBounds(1085, 470, 150, 100);
        start.setBackground(new Color(255, 250, 250));
        start.setBorder(new Border(10, Color.gray));
        start.setFont(letter2);
        start.setVisible(false);

        iniciarHilosButton = new JButton("Iniciar");
        iniciarHilosButton.setBounds(1080, 470, 170, 60);
        iniciarHilosButton.setBackground(new Color(255, 250, 250));
        iniciarHilosButton.setBorder(new Border(10, Color.gray));
        iniciarHilosButton.setFont(letter2);


        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start.setVisible(false);
                initThreads();
                initWinners();
                long startTime = System.currentTimeMillis();

                startsTime(startTime);

                th1.start();
                th2.start();
                th3.start();
                th4.start();
                th5.start();

                if(!flag){
                    th6.start();
                    th7.start();
                    th8.start();
                    th9.start();
                    th10.start();
                    flag = true;
                }

                for (PanelPlayer jugador : jugadores) {
                    jugador.startThreads();
                }

                panelPrincipal.revalidate();
                panelPrincipal.repaint();

                Thread uiThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            th1.join();
                            th2.join();
                            th3.join();
                            th4.join();
                            th5.join();
                        } catch (InterruptedException a) {
                            a.printStackTrace();
                        }

                        start.setVisible(true);
                        setVisible(false);

                        int[] coinAmounts = {50, 40, 30, 20, 10};
                        for (int i = 0; i < coinAmounts.length; i++) {
                            players.get(i).setCoins(players.get(i).getCoins() + coinAmounts[i]);
                        }

                        if (players.get(0).isFlag()) {
                            panelWiners1.panel1(players);
                            panelWiners1.setVisible(true);
                        }else {
                            panelWiners1.finalPanel(players);
                            panelWiners1.getExit().setVisible(true);
                        }
                    }
                });

                uiThread.start();

            }
        });

        iniciarHilosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelPrincipal.add(crearPanelJugador(players.get(0), 30, 10));
                panelPrincipal.add(crearPanelJugador(players.get(1), 480, 10));
                panelPrincipal.add(crearPanelJugador(players.get(2), 930, 10));
                panelPrincipal.add(crearPanelJugador(players.get(3), 30, 390));
                panelPrincipal.add(crearPanelJugador(players.get(4), 480, 390));
                iniciarHilosButton.setVisible(false);
                control.setVisible(true);
                imgIni.setVisible(false);
                start.setVisible(true);

                panelPrincipal.revalidate();
                panelPrincipal.repaint();
            }
        });

        panelPrincipal.add(control);
        panelPrincipal.add(start);
        panelPrincipal.add(about);
        panelPrincipal.add(iniciarHilosButton);
        panelPrincipal.add(imgIni);

        add(panelPrincipal);
        setVisible(true);
    }

    private void initWinners() {
         panelWiners1 = new panelWiners(this);
    }

    private void startsTime(long startTime) {
        runnableDices1.getPlayer().setStartTime(startTime);
        runnableDices2.getPlayer().setStartTime(startTime);
        runnableDices3.getPlayer().setStartTime(startTime);
        runnableDices4.getPlayer().setStartTime(startTime);
        runnableDices5.getPlayer().setStartTime(startTime);
    }

    public void initThreads(){
        runnableDices1 = new RunnableDices(players.get(0));
        runnableDices2 = new RunnableDices(players.get(1));
        runnableDices3 = new RunnableDices(players.get(2));
        runnableDices4 = new RunnableDices(players.get(3));
        runnableDices5 = new RunnableDices(players.get(4));

        th1 = new Thread(runnableDices1);
        th2 = new Thread(runnableDices2);
        th3 = new Thread(runnableDices3);
        th4 = new Thread(runnableDices4);
        th5 = new Thread(runnableDices5);
    }

    private JPanel crearPanelJugador(Player player, int x, int y) {
        PanelPlayer jugadorPanel = new PanelPlayer(player);
        jugadores.add(jugadorPanel);  // Agrega el jugador al listado
        return jugadorPanel.panel(x, y);
    }

    public void uploadGame(){
        for (int i = 0; i < players.size(); i++) {
            players.get(i).uploadGame();
        }
        for (int i = 0; i < jugadores.size(); i++) {
            jugadores.get(i).stopThread();
        }
    }
}



