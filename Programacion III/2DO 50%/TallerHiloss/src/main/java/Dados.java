import java.util.Random;

public class Dados {
    private final static Random random = new Random();

    public static int lanzar() {
        return random.nextInt(6) + 1;
    }
}