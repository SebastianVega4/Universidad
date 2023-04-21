package co.edu.uptc.controller;

import co.edu.uptc.model.Veiculo;

import javax.swing.*;
import java.util.Arrays;
import java.util.Random;

import static co.edu.uptc.model.BusBinario.busquedaBinaria;
import static co.edu.uptc.model.BusLineal.busquedaLineal;
import static co.edu.uptc.model.OrdBubbleSort.bubbleSort;
import static co.edu.uptc.model.OrdInsertionSort.insertionSort;
import static co.edu.uptc.model.OrdMergeSort.mergeSort;
import static co.edu.uptc.model.OrdQuickSort.quickSort;
import static co.edu.uptc.model.OrdSeleccionSort.selectionSort;
import static co.edu.uptc.model.OrdShellSort.shellSort;

public class Controller {
    private Veiculo[] ArrayClone;
    private Veiculo[] ArrayOrig;

    /*public Controller() {
        veiculos = new Veiculo[5];
        veiculos[0] = new Veiculo("Ferrari", "BYW323", "Blue", 2016);
        veiculos[1] = new Veiculo("Audi", "BVS564", "Red", 2018);
        veiculos[2] = new Veiculo("Lamborghini", "ACG876", "Yellow", 2021);
        veiculos[3] = new Veiculo("Mercedes-Benz", "DFA946", "Black", 2019);
        veiculos[4] = new Veiculo("BMW", "KLM789", "White", 2020);
        ArrayOrig = veiculos;
        ArrayClone = ArrayOrig.clone();
    }*/

    public void generarVehiculosAleatorios() {
        Veiculo[] vehiculosAleatorios = new Veiculo[10000];
        Random rnd = new Random();
        String[] marcas = {"Ferrari", "Audi", "Lamborghini", "Mercedes-Benz", "BMW", "Porsche", "Jaguar", "Tesla", "Ford", "Chevrolet", "Honda", "Toyota", "Nissan", "Kia", "Hyundai", "Volvo", "Mazda", "Subaru", "Jeep", "Dodge", "Chrysler", "GMC", "Cadillac", "Buick", "Lincoln", "Infiniti", "Acura", "Land Rover", "Range Rover", "Lexus", "Genesis", "Maserati", "Alfa Romeo", "McLaren", "Bugatti", "Pagani"};
        String[] placa = {"BYW323", "BVS564", "ACG876", "DFA946", "KLM789", "JZM321", "LYN983", "RTF575", "VTE789", "XZL452", "NWR432", "PQS675", "AKF123", "QPT947", "TGM657", "FGN347", "DGH862", "WXL126", "ZVF485", "KLE999", "YHM754", "RBT936", "JDN562", "MCT248", "BQD674", "UPF816", "LSW721", "XRP338", "NKV195", "GJB635"};
        String[] colores = {"Rojo", "Azul", "Amarillo", "Negro", "Blanco", "Verde", "Gris", "Plateado", "Dorado", "Naranja", "Morado", "Rosado", "Turquesa", "Beige", "Marrón", "Rojo oscuro", "Azul oscuro", "Verde oscuro", "Gris oscuro", "Negro mate", "Blanco perlado"};
        int[] year = {2016, 2018, 2021, 2019, 2020, 2017, 2015, 2014, 2013, 2012, 2011, 2010, 2009, 2008, 2007, 2006, 2005, 2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997, 1996, 1995, 1994, 1993, 1992, 1991, 1990, 1989, 1988, 1987, 1986, 1985, 1984, 1983, 1982, 1981, 1980, 1979, 1978, 1977, 1976, 1975, 1974, 1973, 1972, 1971, 1970, 1969, 1968, 1967, 1966, 1965, 1964, 1963, 1962, 1961, 1960};

        for (int i = 0; i < vehiculosAleatorios.length; i++) {
            int marcaIndex = rnd.nextInt(marcas.length);
            int placaIndex = rnd.nextInt(placa.length);
            int colorIndex = rnd.nextInt(colores.length);
            int yearIndex = rnd.nextInt(year.length);
            vehiculosAleatorios[i] = new Veiculo(marcas[marcaIndex], placa[placaIndex], colores[colorIndex], year[yearIndex]);
        }
        ArrayOrig = vehiculosAleatorios;
        ArrayClone = ArrayOrig.clone();
    }

    public void ordenarVehiculos(String ordenamiento) {
        try {
            System.out.println("Arreglo original: " + Arrays.toString(ArrayOrig));
            ArrayClone = ArrayOrig.clone();
            switch (ordenamiento) {
                case "Quick" -> quickSort(ArrayClone, 0, ArrayClone.length - 1);
                case "Merge" -> mergeSort(ArrayClone);
                case "Burbuja" -> bubbleSort(ArrayClone);
                case "Shell" -> shellSort(ArrayClone);
                case "Insercion" -> insertionSort(ArrayClone);
                case "Seleccion" -> selectionSort(ArrayClone);
            }
            JOptionPane.showMessageDialog(null, "Arreglo original: " + Arrays.toString(ArrayOrig) + "\n Arreglo ordenado: " + Arrays.toString(ArrayClone));
            System.out.println("Arreglo ordenado: " + Arrays.toString(ArrayClone));
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Opción de ordenamiento no válida");
            e.printStackTrace();
        }
    }

    public Veiculo buscarVehiculo(String busqueda) {
        try {
            String[] vaBuscar = new String[ArrayClone.length];
            for (int i = 0; i < ArrayClone.length; i++) {
                vaBuscar[i] = ArrayOrig[i].getMarca();
            }
            String vaBuscarr = (String) JOptionPane.showInputDialog(null, "Selecione el algoritmo de Ordenamiento",
                    "VALOR BUSQUEDA", JOptionPane.INFORMATION_MESSAGE, null, vaBuscar, null);
            System.out.println(vaBuscarr);
            switch (busqueda) {
                case "Lineal" -> JOptionPane.showMessageDialog(null, busquedaLineal(ArrayClone, vaBuscarr));
                case "Binaria" -> JOptionPane.showMessageDialog(null, busquedaBinaria(ArrayClone, vaBuscarr));
            }
            return null;
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Opción de búsqueda no válida");
            e.printStackTrace();
            return null;
        }
    }

    public void salir() {
        JOptionPane.showMessageDialog(null, "Hasta luego Gracias");
    }

}
