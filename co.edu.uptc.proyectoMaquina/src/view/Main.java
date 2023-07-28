package view;

import model.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        MaquinaDispensadora<Producto> maquina = new MaquinaDispensadora<>();
        maquina.prender();
        // Crear productos
        Cappuccino cappuccino = new Cappuccino(200.0);
        Latte latte = new Latte(100.0);
        Express express = new Express(300.0);
        // Surtir la máquina con productos
        maquina.surtirProducto(cappuccino, 100);
        maquina.surtirProducto(latte, 150);
        maquina.surtirProducto(express, 80);
        //ingresar dinero base
        maquina.ingresarDineroBase(70000.0);

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 4) {
            System.out.print("""
                        
                    --------- Menú ---------
            1. Realizar venta
            2. Ver reporte de ventas por producto
            3. Ver reporte general de ventas
            4. Salir
                     Ingrese una opción:
            """);
            opcion = scanner.nextInt();
            switch (opcion) {
                //venta
                case 1 -> {
                    System.out.println("""
                    -------Seleccione un producto-------
                    1. Cappuccino
                    2. Latte
                    3. Express
                            Ingrese una opción:
                    """);
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
                    System.out.print("Ingrese el dinero depositado: ");
                    double dineroDepositado = scanner.nextDouble();
                    System.out.println(maquina.realizarVenta(producto, onzas, dineroDepositado));
                }
                //Reporte por producto
                case 2 -> System.out.printf("""
                              ----- Reporte de ventas por producto -----
                                  Producto: Cappuccino: Ventas:%s ,Onzas: %s
                                  Producto: Latte:      Ventas:%s ,Onzas: %s
                                  Producto: Express:    Ventas:%s ,Onzas: %s""",
                        maquina.getVentasPorProducto().get(cappuccino),maquina.getOnzasPorProducto().get(cappuccino),
                        maquina.getVentasPorProducto().get(latte),maquina.getOnzasPorProducto().get(latte),
                        maquina.getVentasPorProducto().get(express),maquina.getOnzasPorProducto().get(express));
                //Reporte de ventas
                case 3 -> System.out.printf("""
                  ----- Reporte general de ventas -----
                        Total de ventas:           %s
                        Total de onzas vendidas:   %s
                        Total de dinero obtenido:$ %s""",maquina.getTotalVentas(),maquina.getTotalOnzas(), maquina.getTotalDinero());
                //Salir
                case 4 -> {
                    maquina.apagar();
                    System.out.println("Saliendo...Gracias por usar nuestra Maquina");
                }
                default -> System.out.println("Opción inválida.");
            }
        }
    }
}
