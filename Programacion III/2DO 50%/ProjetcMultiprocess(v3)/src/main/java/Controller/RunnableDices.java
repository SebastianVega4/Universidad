package Controller;

import Model.Player;

import java.util.Random;

public class RunnableDices implements Runnable {
    Player player;
    private volatile boolean shouldStop = false;


    public RunnableDices(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void stop() {
        shouldStop = true;
    }

    @Override
    public void run() {


        while (!shouldStop && player.getNumberGames() > 0) {
            try {
                player.rollDice();

                System.out.println(player.getName() + " " + "Ahora tiene  " + player.getPoints() + " " + player.getDiceTwo().getNumber() + " + " + player.getDiceOne().getNumber() + "  = " + (player.getDiceTwo().getNumber() + player.getDiceOne().getNumber()));
                player.setPoints(player.getPoints() + player.getDiceTwo().getNumber());
                player.setPoints(player.getPoints() + player.getDiceOne().getNumber());

                if (player.getPoints() > player.getPointsToComplete()) {
                    player.setEndTime(System.currentTimeMillis());
                    player.time();
                    if(player.getNumberGames() > 0){
                        player.setNumberGames(player.getNumberGames() - 1);
                    }
                    if(player.getNumberGames() == 0){
                        player.setFlag(false);
                    }
                    stop();
                }
                Thread.sleep(player.getWaitingTime());

            } catch (InterruptedException e) {
                // Limpia recursos y sale del hilo si es interrumpido
                Thread.currentThread().interrupt(); // Restaura la bandera de interrupción
                break;
            }
        }
    }

}
