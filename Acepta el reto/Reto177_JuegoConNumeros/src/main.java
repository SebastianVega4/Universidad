import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);
        ArrayList<String> cadComplet = new ArrayList<>();
        String[] numZape;
        int aux = 0;
        while (true) {
            String in = cs.nextLine();
            if (Objects.equals(in, "0")) {
                break;
            }
            in += " "+cs.nextLine();
            cadComplet.add(in);
        }
        for (int x = 0; x < cadComplet.size(); x++) {
            numZape = new String[]{"", "", "", "", "", "", "", ""};
            int cont = 0, punZape = 0, punZipi = 0;;
            String numPosZape;
            StringBuilder numCompleto = new StringBuilder();
            numPosZape = cadComplet.get(aux);
            for (int i = 0; i < numPosZape.length(); i++) {
                if (numPosZape.charAt(i) == ' ') {
                    cont++;
                    continue;
                }
                numZape[cont] += numPosZape.charAt(i);
                numCompleto.append(String.valueOf(numPosZape.charAt(i)));
            }
            for (int i = 0; i <= 10_000_000; i++) {
                String numAntiguo = numCompleto.toString();
                numCompleto = new StringBuilder();
                for (int k = 0; k < 8; k++) {
                    int nNum = Integer.parseInt(numZape[k]);
                    numZape[k] = String.valueOf(nNum + 1);
                    numCompleto.append(numZape[k]);
                }
                int iterador = i;
                if (numAntiguo.length() != numCompleto.length()){
                    if (i % 2 == 0){
                        iterador++;
                        punZipi++;
                        System.out.println("Zipi: "+iterador);
                    }else {
                        iterador++;
                        punZape++;
                        System.out.println("Zape: "+iterador);
                    }
                }
            }
            System.out.println("Resultado final: Zipi: "+punZipi+" Zape: "+punZape);
            aux++;
        }
    }
}