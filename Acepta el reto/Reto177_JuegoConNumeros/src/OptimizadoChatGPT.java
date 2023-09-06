import java.util.ArrayList;
import java.util.Scanner;

public class OptimizadoChatGPT {
    private static final int LIMIT = 10_000_000;

    public static void main(String[] args) {
        ArrayList<String> cadComplet = new ArrayList<>();
        try (Scanner cs = new Scanner(System.in)) {
            while (true) {
                String in = cs.nextLine();
                if ("0".equals(in)) {
                    break;
                }
                in += " " + cs.nextLine();
                cadComplet.add(in);
            }
        }

        for (String numPosZape : cadComplet) {
            String[] numZape = numPosZape.split(" ");
            int punZape = 0, punZipi = 0;
            StringBuilder numCompleto = new StringBuilder(numPosZape.replaceAll("\\s+", ""));
            for (int i = 0; i <= LIMIT; i++) {
                String numAntiguo = numCompleto.toString();
                numCompleto.setLength(0);
                for (int k = 0; k < 8; k++) {
                    int nNum = Integer.parseInt(numZape[k]);
                    nNum++;
                    numZape[k] = Integer.toString(nNum);
                    numCompleto.append(numZape[k]);
                }
                int iterador = i;
                if (numAntiguo.length() != numCompleto.length()) {
                    iterador++;
                    if (i % 2 == 0) {
                        punZipi++;
                        System.out.println("Zipi: " + iterador);
                    } else {
                        punZape++;
                        System.out.println("Zape: " + iterador);
                    }
                }
            }
            System.out.println("Resultado final: Zipi: " + punZipi + " Zape: " + punZape);
        }
    }
}