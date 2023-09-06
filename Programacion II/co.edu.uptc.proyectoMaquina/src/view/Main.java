package view;

import model.*;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        MaquinaDispensadora<Producto> maquina = new MaquinaDispensadora<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println(maquina.prender());
        // Crear productos
        Cappuccino cappuccino = new Cappuccino(200.0);
        Latte latte = new Latte(100.0);
        Express express = new Express(300.0);
        //key admin
        int keyAdmin = 1234;

        boolean cycles = true,cycleAll=true;

        while (cycleAll) {
            int optionMaq;
            System.out.print("""
                                
                            --------- Menú ---------
                    1. Administrador
                    2. Cliente
                             Ingrese una opción:
                    """);
            optionMaq = scanner.nextInt();
            switch (optionMaq) {
                //venta
                case 1 -> {
                    System.out.println("Ingrese la contraseña");
                    if(keyAdmin== scanner.nextInt()) {
                        int optionAdim;
                        while (cycles) {
                            System.out.print("""
                                                                 
                                            --------- Menú Admin ---------
                                    1.Surtir Maquina
                                    2.Ver reporte de ventas por producto
                                    3.Ver reporte general de ventas
                                    4.salir del menu admin
                                    5.***********-APAGAR MAQUINA-*************
                                             Ingrese una opción:
                                    """);
                            optionAdim = scanner.nextInt();
                            switch (optionAdim) {
                                case 1 -> {
                                    // Surtir la máquina con productos
                                    maquina.surtirProducto(cappuccino, 100);
                                    maquina.surtirProducto(latte, 150);
                                    maquina.surtirProducto(express, 80);
                                    //ingresar dinero base
                                    System.out.println("Ingrese dinero base");
                                    maquina.ingresarDineroBase(scanner.nextDouble());
                                }
                                //Reporte por producto
                                case 2 -> System.out.printf("""
                                                        ----- Reporte de ventas por producto -----
                                                    Producto: Cappuccino: Ventas:%s ,Onzas: %s ,Dinero: %s
                                                    Producto: Latte:      Ventas:%s ,Onzas: %s ,Dinero: %s
                                                    Producto: Express:    Ventas:%s ,Onzas: %s ,Dinero: %s
                                                """,
                                        maquina.getTotalVentaProducto(cappuccino), maquina.getTotalOnzasProducto(cappuccino),
                                        maquina.getDineroPorProducto().get(cappuccino),
                                        maquina.getTotalVentaProducto(latte), maquina.getTotalOnzasProducto(latte),
                                        maquina.getDineroPorProducto().get(latte),
                                        maquina.getTotalVentaProducto(express), maquina.getTotalOnzasProducto(express),
                                        maquina.getDineroPorProducto().get(express));
                                //Reporte de ventas
                                case 3 -> System.out.printf("""
                                                ----- Reporte general de ventas -----
                                                  Total de ventas:           %s
                                                  Total de onzas vendidas:   %s
                                                  Total de dinero obtenido:$ %s""",
                                        maquina.getTotalVentas(), maquina.getTotalOnzas(), maquina.getTotalDinero());
                                case 4 -> cycles = false;
                                //Apagar maquina
                                case 5 -> {
                                    System.out.println(maquina.apagar());
                                    cycles = false;
                                    cycleAll = false;
                                }
                                default -> System.out.println("Opción inválida.");
                            }
                        }
                    }else {
                        System.out.println("Contraseña Incorrecta");
                    }
                    cycles = true;
                }
                case 2 -> {
                    while (cycles) {
                        int optionSale;
                        System.out.print("""
                                            
                                        --------- Menú Ventas ---------
                                1. Realizar venta
                                2. Salir del menu
                                         Ingrese una opción:
                                """);
                        optionSale = scanner.nextInt();
                        switch (optionSale) {
                            //venta
                            case 1 -> {
                                System.out.println("""
                                        -------Seleccione un producto-------
                                        1. Cappuccino
                                        2. Latte
                                        3. Express
                                              Ingrese una opción:""");
                                int productoSeleccionado = scanner.nextInt();
                                Producto producto;
                                switch (productoSeleccionado) {
                                    case 1 -> producto = cappuccino;
                                    case 2 -> producto = latte;
                                    case 3 -> producto = express;
                                    default -> {
                                        System.out.println("Opción inválida.");
                                        continue;
                                    }
                                }
                                System.out.print("Ingrese el tamaño en onzas (5 o 10): ");
                                int onzas = scanner.nextInt();
                                System.out.println("Su " + producto.getNombre() + " cuesta: " + maquina.getCosto(producto, onzas));
                                System.out.print("Ingrese el dinero: ");
                                double dineroDepositado = scanner.nextDouble();
                                System.out.println(maquina.realizarVenta(producto, onzas, dineroDepositado));
                            }
                            //Salir
                            case 2 -> cycles = false;
                            default -> System.out.println("Opción inválida.");
                        }
                    }
                    cycles = true;
                }
            }
        }
    }
}