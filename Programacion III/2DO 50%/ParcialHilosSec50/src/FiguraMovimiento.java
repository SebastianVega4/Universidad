import javax.swing.*;
import java.util.Random;
public class FiguraMovimiento implements Runnable {
    private Figura figura;
    private JPanel panel;
    private boolean enMovimiento = true;
    private boolean pausado = false;

    public FiguraMovimiento(Figura figura, JPanel panel) {
        this.figura = figura;
        this.panel = panel;
    }

    public void detener() {
        enMovimiento = false;
    }

    public void pausar() {
        pausado = !pausado;
    }

    @Override
    public void run() {
        Random random = new Random();
        int dx = 1 + random.nextInt(3);
        int dy = 1 + random.nextInt(3);
        while (enMovimiento) {
            if (!pausado) {
                moverFigura(dx, dy);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void moverFigura(int dx, int dy) {
        int x = figura.getX();
        int y = figura.getY();
        int width = panel.getWidth();
        int height = panel.getHeight();

        if (x + dx < 0 || x + dx + figura.getWidth() > width) {
            dx = -dx;
        }
        if (y + dy < 0 || y + dy + figura.getHeight() > height) {
            dy = -dy;
        }

        figura.setBounds(x + dx, y + dy, figura.getWidth(), figura.getHeight());
    }
}