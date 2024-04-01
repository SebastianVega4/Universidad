import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Juego {
    private final int numPartidasTotales;
    private final int puntosMeta;
    private final List<Jugador> jugadores;
    private Map<Jugador,Integer> clasificacionFinal = new HashMap<>();
    private Map<Jugador,Integer> clasificacionDePartida = new HashMap<>();
    private int contadorPartidaCompletadas;
    private boolean partidaCompleta= false;
    private int jugadoresQueTerminaronPartida =0;
    private boolean finalJuego;

    public Juego(int numPartidasTotales, int puntosMeta, List<Jugador> jugadores) {
        this.numPartidasTotales = numPartidasTotales;
        this.puntosMeta = puntosMeta;
        this.jugadores = jugadores;
        contadorPartidaCompletadas = 0;
        finalJuego=false;
    }

    public int getNumJugadores(){
        return jugadores.size();
    }
    public void setContadorPartidaCompletadas(int contadorPartidaCompletadas) {
        this.contadorPartidaCompletadas = contadorPartidaCompletadas;
    }

    public int getContadorPartidaCompletadas() {
        return contadorPartidaCompletadas;
    }

    public int getNumPartidasTotales() {
        return numPartidasTotales;
    }

    public void setPartidaCompleta(boolean partidaCompleta) {
        this.partidaCompleta = partidaCompleta;
        if (partidaCompleta && (contadorPartidaCompletadas+1) == numPartidasTotales)finalJuego = true;
        else if (partidaCompleta)finalJuego = false;
    }

    public boolean isPartidaCompleta() {
        return partidaCompleta;
    }

    public ArrayList<String> mostrarClasificacion() {
        ArrayList<String> clasificacion = new ArrayList<String>();
        List<Map.Entry<Jugador, Integer>> listaClasificacion;

        listaClasificacion = new ArrayList<>(clasificacionFinal.entrySet());

        // Ordenar la lista en orden ase según el valor (puntaje)
        listaClasificacion.sort(Map.Entry.comparingByValue());

        // Mostrar la clasificación ordenada
        for (Map.Entry<Jugador, Integer> jugador : listaClasificacion) {
            clasificacion.add(jugador.getKey().getNombre() + "," + jugador.getValue().toString());
        }
        return clasificacion;
    }

    public ArrayList<String> mostrarClasificacionXpartida() {
        ArrayList<String> clasificacion = new ArrayList<String>();
        List<Map.Entry<Jugador, Integer>> listaClasificacion;

        listaClasificacion = new ArrayList<>(clasificacionDePartida.entrySet());

        // Ordenar la lista en orden ase según el valor (puntaje)
        listaClasificacion.sort(Map.Entry.comparingByValue());

        // Mostrar la clasificación ordenada
        for (Map.Entry<Jugador, Integer> jugador : listaClasificacion) {
            clasificacion.add(jugador.getKey().getNombre() + "," + jugador.getValue().toString());
        }
        return clasificacion;
    }

    public int getJugadoresQueTerminaronPartida() {
        return jugadoresQueTerminaronPartida;
    }

    public void setJugadoresQueTerminaronPartida(int jugadoresQueTerminaronPartidas) {
        jugadoresQueTerminaronPartida = jugadoresQueTerminaronPartidas;
    }

    public void setJugadoresClasifi(Jugador jugador){
        clasificacionFinal.put(jugador,0);
        clasificacionDePartida.put(jugador,0);
    }

    public void setClasificacionFinal(Jugador ganJugador) {
        clasificacionDePartida.put(ganJugador,ganJugador.getLanzamientos());
        clasificacionFinal.put(ganJugador, clasificacionFinal.get(ganJugador)+ganJugador.getLanzamientos());
    }

    public int getPuntosMeta() {
        return puntosMeta;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }
}