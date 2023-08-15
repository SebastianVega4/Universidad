package View;

import Logic.*;
import Model.Note;
import java.util.ArrayList;
import java.util.Scanner;

public class DiaryApp {
    public static void main(String[] args) {
        DiaryManager diaryManager = new DiaryManager();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("""
                    
                    Menu de Notas
                    1. Agregar nota
                    2. Eliminar nota
                    3. Consultar nota por título
                    4. Mostrar todas las notas
                    5. Consultar cantidad de notas
                    6. Adicionar nota en posición determinada
                    7. Modificar nota
                    8. Salir
                    Ingrese una opción:
                    """);
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                //Agregar nota
                case 1 -> {
                    System.out.print("Ingrese el título de la nota: ");
                    String title = scanner.nextLine();
                    System.out.print("Ingrese la nota: ");
                    String content = scanner.nextLine();
                    System.out.println(diaryManager.addNote(title,content));
                }
                //Eliminar nota
                case 2 -> {
                    System.out.print("Ingrese el título de la nota a eliminar: ");
                    String titleToRemove = scanner.nextLine();
                    if (diaryManager.getNoteByTitle(titleToRemove) != null) {
                        System.out.println(diaryManager.removeNote(diaryManager.getNoteByTitle(titleToRemove)));
                    } else {
                        System.out.println("No se encontró una nota con ese título.");
                    }
                }
                //Consultar nota por titulo
                case 3 -> {
                    System.out.print("Ingrese el título de la nota a consultar: ");
                    String titleToConsult = scanner.nextLine();
                    Note noteToConsult = diaryManager.getNoteByTitle(titleToConsult);
                    if (noteToConsult != null) {
                        System.out.printf("""
                        Título: %s
                        Contenido: %s
                        """,noteToConsult.getTitle(),noteToConsult.getNote());
                    } else {
                        System.out.println("No se encontró una nota con ese título.");
                    }
                }
                //Mostrar todas las notas
                case 4 -> {
                    ArrayList<Note> allNotes = diaryManager.getAllNotes();
                    if (allNotes.isEmpty()) {
                        System.out.println("No hay notas en la agenda.");
                    } else {
                        System.out.println("Notas en la agenda:");
                        for (Note n : allNotes) {
                            System.out.printf("""
                            Título:   7
                             %s
                            Contenido: %s
                            --------------------
                            """,n.getTitle(),n.getNote());
                        }
                    }
                }
                //Cantidad de nota
                case 5 -> System.out.println(diaryManager.getSizeOfNotes());
                //Adicionar nota en una posicion predeterminado
                case 6 -> {
                    System.out.print("Ingrese el título de la nota a adicionar: ");
                    String titleToAdd = scanner.nextLine();
                    System.out.print("Ingrese la nota a adicionar: ");
                    Note noteToAdd = new Note(titleToAdd, scanner.nextLine());
                    System.out.print("Ingrese la posición en la que desea adicionar la nota: ");
                    System.out.println(diaryManager.addNoteAtPosition(noteToAdd, scanner.nextInt()));
                }
                //Modificar nota
                case 7 -> {
                    System.out.print("Ingrese el título de la nota a modificar: ");
                    Note noteToModify = diaryManager.getNoteByTitle(scanner.nextLine());
                    if (noteToModify != null) {
                        System.out.print("Ingrese la nueva nota: ");
                        System.out.println(diaryManager.modifyNoteContent(noteToModify, scanner.nextLine()));
                    } else {
                        System.out.println("No se encontró una nota con ese título.");
                    }
                }
                //salir
                case 8 -> exit = true;
                default -> System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        }
        System.out.println("¡Hasta luego!");
    }
}