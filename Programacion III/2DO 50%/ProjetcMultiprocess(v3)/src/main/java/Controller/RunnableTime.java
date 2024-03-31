package Controller;

import Model.Player;

public class RunnableTime implements Runnable{
    Player player;

    public RunnableTime(Player player) {
        this.player = player;
    }

    @Override
    public void run() {
        while (true) {
            try {
                player.calculateHour();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Limpia recursos y sale del hilo si es interrumpido
                Thread.currentThread().interrupt(); // Restaura la bandera de interrupción
                break;
            }
        }
    }
}

   /* @Override
    public void run() {
        while (true) {
            player.calculateHour();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    }*/

