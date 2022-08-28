import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);int g = sc.nextInt();
        sc.nextLine();String N[] = new String[g];
        for (int i = 0; i < g; i++){N[i] = sc.nextLine();N[i]= N[i].replaceAll("Soy","Hola,");}
        for (int i = 0; i < N.length; i++) System.out.println(N[i]+".");}}