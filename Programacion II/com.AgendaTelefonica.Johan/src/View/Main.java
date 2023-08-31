package View;

import Logic.AgentContacs;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AgentContacs agend = new AgentContacs();
        boolean exit = true;
        int option = 0;
        while (exit) {
           try {
                System.out.println("""
                                        
                        **************************************
                              Ingrese la opcion a elegir:
                        1.Ingresar Contacto.
                        2.Modificar Contacto.
                        3.Borrar Contacto.
                        4.Buscar Contacto por la primera letra.
                                        
                        5.SALIR
                        ***************************************
                                        
                        """);
                option = sc.nextInt();

                switch (option) {
                    case 1 -> {
                            System.out.println("""
                                    ***************************************
                                             Ingrese el nombre:
                                    ***************************************
                                    """);
                            sc.nextLine();
                            String name = sc.nextLine();
                            System.out.println("""
                                    ***************************************
                                             Ingrese el Numero:
                                    ***************************************
                                    """);
                            agend.addContacs(name, sc.nextLine());
                    }
                    case 2 -> {
                        System.out.println("""
                                *****************************************
                                Ingrese el nombre del numero a modificar:
                                *****************************************
                                """);
                        sc.nextLine();
                        String name = sc.nextLine();
                        System.out.println("""
                                *****************************************
                                      Ingrese el nuevo numero:
                                *****************************************
                                """);
                        System.out.println(agend.modificContacs(name, sc.nextLine()));
                    }
                    case 3 -> {
                        System.out.println("""
                                *****************************************
                                 Ingrese el nombre del numero a BORRAR:
                                *****************************************
                                """);
                        sc.nextLine();
                        System.out.println(agend.eraseContac(sc.nextLine()));
                    }
                    case 4 -> {
                        System.out.println("""
                                *****************************************
                                     Ingrese la Letra tal y como
                                   esta la inicial Mayuscula o minuscula
                                *****************************************
                                """);
                        char caracter = sc.next().charAt(0);
                        System.out.println(agend.findContacForFirstLater(caracter));
                    }
                    case 5 -> {
                        exit = false;
                        System.out.println("Hasta Luego");
                    }
                    default -> {
                        System.out.println("Digite una opcion valida");
                    }
                }
           } catch (InputMismatchException e) {
               System.out.println("ingrese un valor valido" + e);
               sc.nextLine();
               continue;
           }
        }
    }
}