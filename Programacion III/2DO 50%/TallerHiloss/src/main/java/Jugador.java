import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.*;

public class Jugador implements Runnable {
    private final String nombre;
    private final String ubicacion;
    private final int edad;
    private final Juego juego;
    private final InterfazJuego interfaz;
    private int numPartida;
    private int numLanzamiento;
    private int puntaje;
    private int puntajeObtenidoDados;
    private CyclicBarrier barrier;


    public Jugador(String nombre, String ubicacion, int edad, Juego juego, InterfazJuego interfaz) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.edad = edad;
        this.juego = juego;
        this.interfaz = interfaz;
        this.numLanzamiento = 0;
        this.puntaje = 0;
    }

    @Override
    public void run() {
        iniciarHiloHora();
        for (numPartida = 1; numPartida <= juego.getNumPartidasTotales(); numPartida++) {
            puntaje = 0;
            numLanzamiento = 0;
            while (puntaje < juego.getPuntosMeta()) {
                numLanzamiento++;
                int dado1 = Dados.lanzar();
                int dado2 = Dados.lanzar();
                puntaje += dado1 + dado2;
                puntajeObtenidoDados = dado1 + dado2;
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (puntaje >= juego.getPuntosMeta()) break;
            }
            try {
                juego.setClasificacionFinal(this);
                juego.setJugadoresQueTerminaronPartida(juego.getJugadoresQueTerminaronPartida() + 1);
                if (juego.getJugadoresQueTerminaronPartida() == juego.getNumJugadores()) {
                    juego.setPartidaCompleta(true);
                    InterfazJuego.habilitarBotonIniciarPartida();
                    juego.setContadorPartidaCompletadas(juego.getContadorPartidaCompletadas() + 1);
                }
                barrier.await(); // Esperar a que todos los jugadores finalicen antes de continuar con la siguiente partida
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void setBarrier(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    public void reset() {
        numLanzamiento = 0;
        puntaje = 0;
        puntajeObtenidoDados = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getLanzamientos() {
        return numLanzamiento;
    }

    public String obtenerHoraActual() {
        ZoneId zonaHoraria = ZoneId.of(ubicacion);
        ZonedDateTime horaActual = ZonedDateTime.now(zonaHoraria);
        return horaActual.toLocalTime().getHour() + ":" + horaActual.toLocalTime().getMinute() + ":" + horaActual.toLocalTime().getSecond() + ".";
    }

    public int getPuntaje() {
        return puntajeObtenidoDados;
    }

    public int getSumaPuntajes() {
        return puntaje;
    }

    public int getPuntajeRestante() {
        return juego.getPuntosMeta() - puntaje;
    }

    private synchronized void iniciarHiloHora() {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(() -> interfaz.actualizarInterfaz(juego.getJugadores()), 0, 1, TimeUnit.SECONDS);
    }

    public String getUbicacion() {
        return ubicacion;
    }
}