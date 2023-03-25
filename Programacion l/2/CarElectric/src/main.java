import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        CarElectric electric = new CarElectric(100, "Tesla Model S", "2022", "Red", "BYW323", TypeCar.Electric);
        CarDiesel Disel = new CarDiesel(100, "Mercedes-Benz C 220 d", "2020", "Black", "RTH854", TypeCar.Diesel);
        CarGasoline Corriente = new CarGasoline(100, "Ferrari California T", "2014", "Green", "UJS293", TypeCar.Gasoline);
        RotatoryWing Helicptero = new RotatoryWing(100, "Helicoptero", "2015", "Yellow", "TIU204", TypeCar.Aereo);
        FixedWing Avion = new FixedWing(100, "Avion Boing 70", "2010", "Green", "UJS293", TypeCar.Aereo);
        Scanner sc = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("""
                                
                    ****************************************************
                       Elija la opcion segun el carro a encender
                          1=Electric   2=Disel   3=Corriente
                            4=Helicoptero    5=Avion    6=SALIR
                    ****************************************************""");
            try {
                option = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Por favor ingrese un valor numérico");
                sc.next();
                continue;
            }
            try {
                switch (option) {
                    case 1 -> {
                        electric.powerOn(true);
                        System.out.println("\n¿Desea acelerar el carro eléctrico? (s/n)");
                        String response = sc.next();
                        if (response.equalsIgnoreCase("s")) {
                            electric.acelerar(20);
                        }
                        System.out.println("\n" + electric);
                    }
                    case 2 -> {
                        Disel.powerOn(true);
                        Disel.powerOff(true);
                        System.out.println("\n" + Disel);}
                    case 3 -> {
                        Corriente.powerOn(true);
                        Corriente.powerOff(true);
                        System.out.println("\n" + Corriente);}
                    case 4 -> {
                        Helicptero.powerOn(true);
                        Helicptero.takeOffVerticall();
                        Helicptero.powerOff(true);
                        System.out.println("\n" + Helicptero);
                    }
                    case 5 -> {
                        Avion.powerOn(true);
                        Avion.takeOffDiagonel();
                        Avion.powerOff(true);
                        System.out.println("\n" + Avion);
                    }
                    case 6 -> System.out.println("Hasta luego");
                    default -> throw new IndexOutOfBoundsException("La opción seleccionada no es válida");
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
                // Vuelve a pedir la opción al usuario
            }
        } while (option != 6);
    }
}