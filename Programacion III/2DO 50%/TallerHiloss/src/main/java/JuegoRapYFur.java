import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class JuegoRapYFur {
    public static void main(String[] args) {
        int numPartidas = 0;
        int puntosMeta = 0;

        try (InputStream inputStream = JuegoRapYFur.class.getResourceAsStream("/config.txt");
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            numPartidas = Integer.parseInt(br.readLine());
            puntosMeta = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Jugador> jugadores = new ArrayList<>();
        Juego juego = new Juego(numPartidas, puntosMeta, jugadores);
        InterfazJuego interfaz = new InterfazJuego(juego);

        try (InputStream inputStream = JuegoRapYFur.class.getResourceAsStream("/jugadores.txt");
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(" ");
                Jugador jugador = new Jugador(datos[0], datos[1], Integer.parseInt(datos[2]), juego, interfaz);
                jugadores.add(jugador);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            for (Jugador jugador : jugadores) {
                juego.setJugadoresClasifi(jugador);
                jugador.setBarrier(new CyclicBarrier(jugadores.size()));
                jugador.reset();
            }
        });
        
        interfaz.initComponents();
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(() -> interfaz.actualizarInterfaz(jugadores), 0, 1, TimeUnit.SECONDS);

    }
}