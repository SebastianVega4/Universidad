import java.util.Scanner;
public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int menu = 0 , Numero=0;
        String polar[] = new String[9];
        String unipolar[] = new String[9];
        String bipolar[] = new String[9];
        int num[] = new int[9];
        int  div = 100_000_000, s= 0;

        //Ingresar numero
        do{
            System.out.println("\n****************************************");
            System.out.println("    Digite el binario a codificar:");
            System.out.println("****************************************");
            Numero = sc.nextInt();
        }while (Numero< 100_000_000 && Numero>111_111_111);
        //Separar y guardar digitos
        div = 100_000_000;
        s= 0;
        for (int i=0;div!=0;i++){
            s =Numero/ div;
            div =  div /10;
            //Separar digitos del binario
            s =s % 10;
            num[i] = s;
        }

        //que codificacion mostrar
        do {
            do {
                System.out.println("\n*****************************************");
                System.out.println("Escriba la forma de codificacion a usar:");
                System.out.println("     1=Unipolar  2=Polar 3=Bipolar");
                System.out.println("      4=Cambiar Numero 5=Salir " );
                System.out.println("*****************************************");
                menu = sc.nextInt();
            }while (menu<1 && menu>5 );

            //Analizar entrada del menu
            switch (menu) {
                //Unipolar
                case 1:
                    do{
                        System.out.println("*********************************************");
                        System.out.println("    1=Unipolar Positiva  2=Unipolar Negativa ");
                        System.out.println("*********************************************");
                        menu = sc.nextInt();
                    }while (menu<1 && menu>2 );

                    switch (menu) {
                    //Unipolar Positiva
                        case 1:
                            for (int j = 0; j < unipolar.length; j++){
                                if (num[j]==1 ){
                                    unipolar[j] ="|¯";
                                } else if (num[j]==0) {
                                    unipolar[j] ="|_";
                                }
                                if (num[j]==1 && j!=0 && num[j-1]==1){
                                    unipolar[j] ="¯";
                                }
                                if (num[j]==0 && j!=0 && num[j-1]==0){
                                    unipolar[j] ="_";
                                }

                            };
                            for (int k = 0; k < unipolar.length; k++) System.out.print(unipolar[k]);
                            System.out.println("");
                            System.out.println(Numero);
                        break;
                    //Unipolar Negativa
                        case 2:
                            for (int j = 0; j < unipolar.length; j++){
                                if (num[j]==0 ){
                                    unipolar[j] ="|¯";
                                } else if (num[j]==1) {
                                    unipolar[j] ="|_";
                                }
                                if (num[j]==0 && j!=0 && num[j-1]==0){
                                    unipolar[j] ="¯";
                                }
                                if (num[j]==1 && j!=0 && num[j-1]==1){
                                    unipolar[j] ="_";
                                }
                            };
                            for (int k = 0; k < unipolar.length; k++) System.out.print(unipolar[k]);
                            System.out.println("");
                            System.out.println(Numero);
                        break;
                        default: System.out.println("digite un valor valido");
                    }
                    break;
                //Polar
                case 2:
                    for (int j = 0; j < polar.length; j++){
                        if (num[j]==0){
                            polar[j] ="|_";
                        } else if (num[j]==1) {
                            polar[j] ="|¯";
                        }
                        if (num[j]==1 && j==0){
                            polar[j] ="├¯";
                        } else if (num[j]==0 && j==0) {
                            polar[j] ="├_";
                        }
                        if (num[j]==1 && j!=0 && num[j-1]==1){
                            polar[j] ="¯";
                        }
                        if (num[j]==0 && j!=0 && num[j-1]==0){
                            polar[j] ="_";
                        }
                    }
                    for (int k = 0; k < polar.length; k++) System.out.print(polar[k]);
                    System.out.println("");
                    System.out.println(Numero);
                    break;
                //Bipolar
                case 3:
                    do{
                        System.out.println("*********************************************");
                        System.out.println("    1=Alternada a 1  2=Alternada a 0 ");
                        System.out.println("*********************************************");
                        menu = sc.nextInt();
                    }while (menu<1 && menu>2 );
                    switch (menu){
                        case 1:
                            int cambio= 0;
                            for (int j = 0; j < bipolar.length; j++){
                                if (num[j]==1 && j==0){
                                    bipolar[j] ="├¯";
                                    cambio = 1;
                                }else if (num[j]==0 && j==0) {
                                    bipolar[j] ="├-";
                                }else if (num[j]==1 && cambio == 1){
                                    bipolar[j] ="|_";
                                    cambio = 0;
                                }else if (num[j]==1){
                                    bipolar[j] ="|¯";
                                    cambio = 1;
                                }else if (num[j]==0) {
                                    bipolar[j] ="|-";
                                }
                                if (num[j]==0 && j!=0 && num[j-1]==0){
                                    bipolar[j] ="-";
                                }
                            }
                            for (int i = 0; i < bipolar.length; i++) System.out.print(bipolar[i]);
                            System.out.println("");
                            System.out.println(Numero);
                            break;
                        case 2:
                            cambio= 0;
                            for (int j = 0; j < bipolar.length; j++){
                                if (num[j]==0 && j==0){
                                    bipolar[j] ="├¯";
                                    cambio = 1;
                                }else if (num[j]==1 && j==0) {
                                    bipolar[j] ="├-";
                                }else if (num[j]==1 && cambio == 1){
                                    bipolar[j] ="|¯";
                                    cambio = 0;
                                }else if (num[j]==1){
                                    bipolar[j] ="|-";
                                    cambio = 1;
                                }else if (num[j]==0) {
                                    bipolar[j] ="|¯";
                                }
                                if (num[j]==1 && j!=0 && num[j-1]==1){
                                    bipolar[j] ="-";
                                }
                            }
                            for (int i = 0; i < bipolar.length; i++) System.out.print(bipolar[i]);
                            System.out.println("");
                            System.out.println(Numero);
                            break;
                        default:
                    }

                    break;
                //Cambiar numero
                case 4:
                    do{
                        System.out.println("\n****************************************");
                        System.out.println("    Digite el binario a codificar:");
                        System.out.println("****************************************");
                        Numero = sc.nextInt();
                    }while (Numero< 100_000_000 && Numero>111_111_111);
                    //Separar y guardar digitos
                    div = 100_000_000;
                    s= 0;
                    for (int i=0;div!=0;i++){
                        s =Numero/ div;
                        div =  div /10;
                        //Separar digitos del binario
                        s =s % 10;
                        num[i] = s;
                    }
                    System.out.println("");
                    System.out.println(Numero);
                    for (int i = 0; i < num.length; i++) System.out.print(num[i]);
                    break;
                //Salir
                case 5:System.out.println("EXIT");
                    break;
                default:System.out.println("digite un valor valido");
                }
        }while (menu!=5);
    }
}
