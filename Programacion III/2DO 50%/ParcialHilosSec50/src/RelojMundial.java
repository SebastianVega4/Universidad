import javax.swing.*;
import java.awt.*;
public class RelojMundial extends JFrame {
    JLabel horaLabel;
    JLabel horaLabel2;
    JLabel horaLabel3;
    JButton playButton;
    JButton pauseButton;
    JButton stopButton;
    JPanel panelSuperior;
    JPanel panelInferior;
    JPanel panelCentro;

    public RelojMundial() {
        setTitle("Reloj Mundial");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        horaLabel = new JLabel();
        horaLabel2 = new JLabel();
        horaLabel3 = new JLabel();
        panelSuperior = new JPanel();
        panelSuperior.add(horaLabel);
        panelSuperior.add(horaLabel2);
        panelSuperior.add(horaLabel3);

        playButton = new JButton("Play");
        pauseButton = new JButton("Pause");
        stopButton = new JButton("Stop");
        panelInferior = new JPanel();
        panelInferior.add(playButton);
        panelInferior.add(pauseButton);
        panelInferior.add(stopButton);

        panelCentro = new JPanel();
        panelCentro.setLayout(null);

        add(panelSuperior, BorderLayout.NORTH);
        add(panelInferior, BorderLayout.SOUTH);
        add(panelCentro, BorderLayout.CENTER);

        setVisible(true);
    }
}