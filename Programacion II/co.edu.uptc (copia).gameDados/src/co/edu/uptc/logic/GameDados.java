package co.edu.uptc.logic;

public class GameDados implements Juego{

    private Player ganador;
    private Player player1;
    private Player player2;
    public GameDados() {
       player1 = new Player("Sebastian");
       player2 = new Player("Saritha");
       calGanador();
    }

    @Override
    public String iniciar() {
        return "El juego a iniciado";

    }

    @Override
    public String jugar() {
        return "Los resultado de los dados fueron: \n" + player1.getName()+": " + player1.valDados() +"\n" + player2.getName()+": "  + player2.valDados();

    }

    @Override
    public String finalizar() {
        return "El jugaor ganador fue: \n " + ganador.getName() + "\n";
    }

    public void calGanador() {
        if (player1.valDados() > player2.valDados()) {
            ganador = player1;
        } else if (player1.valDados() < player2.valDados()) {
            ganador = player2;
        }
    }


}
