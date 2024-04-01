import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InterfazJuego extends JFrame {

    private JPanel[] JPjugadores;
    private JPanel[] JPinfo;
    private JPanel JPclasificacion, JPinfoClasificacion;
    private static JButton JBIniciarPartida, JBacercaDe;
    private JLabel JLclasificacion;
    private final Juego juego;
    private boolean partidaEnCurso;

    public InterfazJuego(Juego juego) {
        this.juego = juego;
        JPclasificacion = new JPanel();
        JPjugadores = new JPanel[5];
        JPinfo = new JPanel[5];
        JPinfoClasificacion = new JPanel();
        JBIniciarPartida = new JButton("Iniciar Partida");
        JLclasificacion = new JLabel("CLASIFICACION");
        partidaEnCurso = false;
        JBacercaDe = new JButton("Acerca de");

        setLayout(new GridLayout(2, 3));

        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Rapido y furioso");
        setResizable(false);
    }

    public void initComponents() {

        int indexA = 0;
        for (JPanel jp : JPjugadores) {
            jp = new JPanel();
            jp.setBackground(new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
            jp.setLayout(null);
            JPanel info = new JPanel();
            JPinfo[indexA] = info;
            info.setBounds(35, 5, 250, 160);
            info.setBorder(new EmptyBorder(20, 30, 10, 10));
            JLabel avatar = new JLabel(modificarTamImagen("/" + indexA + ".png", 100, 100));
            avatar.setBounds(-10, 120, 200, 200);

            JLabel nombre = new JLabel(juego.getJugadores().get(indexA).getNombre());
            nombre.setFont(new Font("Arial", Font.PLAIN, 30));
            nombre.setForeground(Color.black);
            nombre.setBounds(150, 200, 200, 30);

            jp.add(nombre);
            jp.add(avatar);
            jp.add(info);

            add(jp);
            indexA++;
        }

        JLclasificacion.setFont(new Font("Times New Roman", Font.ITALIC, 30));
        JLclasificacion.setForeground(Color.blue);
        JLclasificacion.setBounds(50, 5, 300, 30);

        JLabel estrellas = new JLabel(modificarTamImagen("/estrellas.png", 120, 50));
        estrellas.setBounds(100, 20, 130, 80);

        JPclasificacion.setLayout(null);

        JPinfoClasificacion.setBorder(new EmptyBorder(10, 30, 10, 10));
        JPinfoClasificacion.setBackground(new Color(255, 255, 131));
        JPinfoClasificacion.setBounds(20, 70, 280, 150);

        JBacercaDe.addActionListener(e -> mostrarInformacionEquipo());
        JBacercaDe.setBounds(220, 230, 100, 50);

        functionBoton();
        JPclasificacion.add(JLclasificacion);
        JPclasificacion.add(estrellas);
        JPclasificacion.add(JPinfoClasificacion);
        JPclasificacion.add(JBIniciarPartida);
        JPclasificacion.add(JBacercaDe);

        add(JPclasificacion);
        setVisible(true);
    }

    private void mostrarInformacionEquipo() {
        // Crear un mensaje con la información del equipo de trabajo
        String informacion = "Integrantes del Equipo de Trabajo:\n\n" +
                "- Sebastian Vega\n" +
                "- Jazmin Moreno";

        // Mostrar la ventana modal con la información
        JOptionPane.showMessageDialog(this, informacion, "Acerca de...", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void habilitarBotonIniciarPartida() {
        JBIniciarPartida.setEnabled(true);
    }

    private void functionBoton() {
        JBIniciarPartida.setBounds(10, 230, 200, 50);
        JBIniciarPartida.setBackground(new Color(255, 255, 255));
        JBIniciarPartida.setForeground(Color.blue);
        JBIniciarPartida.setFont(new Font("Time new Roman", Font.BOLD, 20));
        JBIniciarPartida.setBorder(BorderFactory.createLineBorder(Color.blue, 2));

        JBIniciarPartida.addActionListener(e -> {
            if (juego.getContadorPartidaCompletadas() < juego.getNumPartidasTotales() && !partidaEnCurso) {
                juego.setJugadoresQueTerminaronPartida(0);
                juego.setPartidaCompleta(false);
                partidaEnCurso = true;
                JBIniciarPartida.setEnabled(false);

                ExecutorService executorService = Executors.newFixedThreadPool(juego.getJugadores().size());

                for (Jugador jugador : juego.getJugadores()) {
                    executorService.submit(() -> {
                        jugador.reset();
                        new Thread(jugador).start();
                    });
                }
                executorService.shutdown();
            } else
                JOptionPane.showMessageDialog(this, "¡Todas las partidas han sido completadas! GRACIAS POR JUGAR", "Fin del juego", JOptionPane.INFORMATION_MESSAGE);
            partidaEnCurso = false;
        });
    }

    public void actualizarInterfaz(List<Jugador> jugadores) {

        SwingUtilities.invokeLater(() -> {
            for (int i = 0; i < JPinfo.length; i++) {
                actualizarCasilla(JPinfo[i], juego.getJugadores().get(i));
            }
        });

    }

    private void actualizarCasilla(JPanel casilla, Jugador jugador) {
        casilla.removeAll();
        casilla.setLayout(new BoxLayout(casilla, BoxLayout.Y_AXIS));
        casilla.add(new JLabel(jugador.getUbicacion()));
        casilla.add(new JLabel("Hora: " + jugador.obtenerHoraActual()));

        if (juego.isPartidaCompleta()) {
            JPinfoClasificacion.removeAll();
            JPinfoClasificacion.setLayout(new GridLayout(5, 3));
            int i = 1;
            //Clasificacion acumulada
            for (String linea : juego.mostrarClasificacion()) {

                JLabel puesto = new JLabel(String.valueOf(i));
                puesto.setFont(new Font("Comic Sans MS", Font.BOLD + Font.ITALIC, 30));
                puesto.setForeground(Color.red);

                JLabel nombre = new JLabel(linea.split(",")[0]);
                nombre.setFont(new Font("Comic Sans MS", Font.BOLD + Font.ITALIC, 20));
                nombre.setForeground(Color.black);

                JLabel puntaje = new JLabel(linea.split(",")[1]);
                puntaje.setFont(new Font("Comic Sans MS", Font.BOLD + Font.ITALIC, 20));
                puntaje.setForeground(Color.black);

                JPinfoClasificacion.add(puesto);
                JPinfoClasificacion.add(nombre);
                JPinfoClasificacion.add(puntaje);

                i++;
            }
            //clasificacion por partida para las casillas
            int j = 1;
            for (String linea : juego.mostrarClasificacionXpartida()) {
                if (linea.split(",")[0].equalsIgnoreCase(jugador.getNombre())) {
                    JLabel aux1 = new JLabel("Puesto ocupado: " + j);
                    aux1.setForeground(Color.red);
                    aux1.setFont(new Font("Verdana", Font.BOLD + Font.ITALIC, 15));
                    casilla.add(aux1);
                }
                j++;
            }
            JLabel fin = new JLabel("FIN DE LA");
            JLabel partida = new JLabel("PARTIDA");
            if ((juego.getContadorPartidaCompletadas()) == juego.getNumPartidasTotales()) {
                fin.setText("FIN DEL");
                partida.setText("JUEGO");
            } else {

            }
            fin.setForeground(Color.ORANGE);
            fin.setFont(new Font("Verdana", Font.BOLD + Font.ITALIC, 25));
            partida.setForeground(Color.orange);
            partida.setFont(new Font("Verdana", Font.BOLD + Font.ITALIC, 25));
            casilla.add(fin);
            casilla.add(partida);
        } else {
            if ((juego.getContadorPartidaCompletadas()) == juego.getNumPartidasTotales())
                casilla.add(new JLabel("Numero de partida: " + juego.getContadorPartidaCompletadas() + "/" + juego.getNumPartidasTotales()));
            else
                casilla.add(new JLabel("Numero de partida: " + (juego.getContadorPartidaCompletadas() + 1) + "/" + juego.getNumPartidasTotales()));

            if (jugador.getSumaPuntajes() >= juego.getPuntosMeta()) {
                JLabel gano = new JLabel("¡GANOOOO!");
                gano.setForeground(Color.red);
                gano.setFont(new Font("Verdana", Font.BOLD + Font.ITALIC, 25));
                casilla.add(gano);
            } else {
                casilla.add(new JLabel("Puntaje obtenido: " + jugador.getPuntaje()));
                casilla.add(new JLabel("Puntaje restante: " + jugador.getPuntajeRestante()));
            }
            casilla.add(new JLabel("Suma de los puntajes: " + jugador.getSumaPuntajes()));
        }
        casilla.add(new JLabel("Numero de lanzamiento: " + jugador.getLanzamientos()));
        casilla.revalidate();
        casilla.repaint();
    }

    private ImageIcon modificarTamImagen(String imagePath, int w, int h) {
        try {
            InputStream inputStream = getClass().getResourceAsStream(imagePath);
            if (inputStream != null) {
                byte[] imageBytes = inputStream.readAllBytes();
                ImageIcon originalIcon = new ImageIcon(imageBytes);

                Image originalImage = originalIcon.getImage();
                Image resizedImage = originalImage.getScaledInstance(w, h, Image.SCALE_SMOOTH);

                return new ImageIcon(resizedImage);
            } else {
                return null;  // o devolver un icono de reemplazo, según tus necesidades
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;  // o devolver un icono de reemplazo, según tus necesidades
        }
    }
}