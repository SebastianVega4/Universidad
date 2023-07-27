package view;

import model.*;

import java.util.Map;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        MaquinaDispensadora<Producto> maquina = new MaquinaDispensadora<>();
        maquina.prender();

        // Crear productos
        Cappuccino cappuccino = new Cappuccino(200.0, 100);
        Latte latte = new Latte(100.0, 150);
        Express express = new Express(300.0, 80);

        // Surtir la máquina con productos
        maquina.surtirProducto(cappuccino, 100);
        maquina.surtirProducto(latte, 150);
        maquina.surtirProducto(express, 80);

        maquina.ingresarDineroBase(70000.0);

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 4) {
            System.out.println("----- Menú -----");
            System.out.println("1. Realizar venta");
            System.out.println("2. Ver reporte de ventas por producto");
            System.out.println("3. Ver reporte general de ventas");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Seleccione un producto:");
                    System.out.println("1. Cappuccino");
                    System.out.println("2. Latte");
                    System.out.println("3. Express");
                    System.out.print("Ingrese una opción: ");
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
                    String resultado = maquina.realizarVenta(producto, onzas, dineroDepositado);
                    System.out.println(resultado);
                }
                case 2 -> {
                    System.out.println("----- Reporte de ventas por producto -----");
                    Map<Producto, Integer> ventasPorProducto = maquina.getVentasPorProducto();
                    System.out.println("Producto: Cappuccino, Ventas: " + ventasPorProducto.get(cappuccino));
                    System.out.println("Producto: latte, Ventas: " + ventasPorProducto.get(latte));
                    System.out.println("Producto: Express, Ventas: " + ventasPorProducto.get(express));
                }
                //
                case 3 -> {
                    System.out.println("----- Reporte general de ventas -----");
                    System.out.println("Total de ventas: " + maquina.getTotalVentas());
                    System.out.println("Total de onzas vendidas: " + maquina.getTotalOnzas());
                    System.out.println("Total de dinero obtenido: $" + maquina.getTotalDinero());
                }
                case 4 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        }
    }
}
