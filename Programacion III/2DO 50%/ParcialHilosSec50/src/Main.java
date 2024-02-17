import java.awt.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        RelojMundial relojMundial = new RelojMundial();
        Thread hiloHora1 = new Thread(new HiloHora(relojMundial.horaLabel, "America/New_York"));
        Thread hiloHora2 = new Thread(new HiloHora(relojMundial.horaLabel2, "Europe/London"));
        Thread hiloHora3 = new Thread(new HiloHora(relojMundial.horaLabel3, "Asia/Tokyo"));
        hiloHora1.start();
        hiloHora2.start();
        hiloHora3.start();

        Figura figura1 = new Figura(50, 50, 50, 50, Color.RED);
        Figura figura2 = new Figura(150, 100, 30, 30, Color.BLUE);
        Figura figura3 = new Figura(190, 150, 80, 50, Color.CYAN);
        relojMundial.panelCentro.add(figura1);
        relojMundial.panelCentro.add(figura2);
        relojMundial.panelCentro.add(figura3);

        FiguraMovimiento movimiento1 = new FiguraMovimiento(figura1, relojMundial.panelCentro);
        FiguraMovimiento movimiento2 = new FiguraMovimiento(figura2, relojMundial.panelCentro);
        FiguraMovimiento movimiento3 = new FiguraMovimiento(figura3, relojMundial.panelCentro);
        Thread hiloMovimiento1 = new Thread(movimiento1);
        Thread hiloMovimiento2 = new Thread(movimiento2);
        Thread hiloMovimiento3 = new Thread(movimiento3);

        relojMundial.playButton.addActionListener(e -> {
            hiloMovimiento1.start();
            hiloMovimiento2.start();
            hiloMovimiento3.start();
        });

        relojMundial.pauseButton.addActionListener(e -> {
            movimiento1.pausar();
            movimiento2.pausar();
            movimiento3.pausar();
        });

        relojMundial.stopButton.addActionListener(e -> {
            movimiento1.detener();
            movimiento2.detener();
            movimiento3.detener();
            hiloMovimiento1.interrupt();
            hiloMovimiento2.interrupt();
            hiloMovimiento3.interrupt();
        });
        hiloMovimiento1.join();
        hiloMovimiento2.join();
        hiloMovimiento3.join();
    }
}