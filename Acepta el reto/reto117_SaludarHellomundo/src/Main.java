/*import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();
        sc.nextLine();
        String[] N = new String[g];
        for (int i = 0; i < g; i++) {
            N[i] = sc.nextLine();
            N[i] = N[i].replaceAll("Soy", "Hola,");
        }
        for (int i = 0; i < N.length; i++) System.out.println(N[i] + ".");
    }
}
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int g = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < g; i++) {
            sb.append(sc.nextLine().replace("Soy", "Hola,")).append(".\n");
        }
        System.out.print(sb.toString());
    }
}*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int g = Integer.parseInt(sc.nextLine());
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < g; i++) {
            String n = sc.nextLine().replace("Soy", "Hola,");
            output.append(n).append(".\n");
        }
        System.out.print(output.toString());
    }
}