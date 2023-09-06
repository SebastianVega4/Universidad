package View;

import Logic.DiaryManager;
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
                                        
                    Menu de Asignaturas
                    1. Agregar asignatura
                    2. Eliminar asignatura
                    3. Ir a notas
                    4.Salir del programa
                    Ingrese una opción:
                    """);
            int menuA = scanner.nextInt();
            scanner.nextLine();
            switch (menuA) {
                // Agregar asignatura
                case 1 -> {
                    System.out.print("Ingrese el nombre de la asignatura: ");
                    String subject = scanner.nextLine();
                    diaryManager.addSubject(subject);
                    System.out.println("Asignatura agregada correctamente.");
                }
                // Eliminar asignatura
                case 2 -> {
                    System.out.print("Ingrese el nombre de la asignatura a eliminar: ");
                    String subjectToRemove = scanner.nextLine();
                    if (diaryManager.removeSubject(subjectToRemove)) {
                        System.out.println("Asignatura eliminada correctamente.");
                    } else {
                        System.out.println("No se encontró una asignatura con ese nombre.");
                    }
                }
                // Menu notas
                case 3 -> {
                    if (!diaryManager.getSubjects().isEmpty()) {
                        boolean exitNotesMenu = false;
                        while (!exitNotesMenu) {
                            System.out.println("""
                                                            
                                    Menu de Notas
                                    1. Agregar nota
                                    2. Eliminar nota
                                    3. Consultar nota por título
                                    4. Mostrar todas las notas
                                    5. Consultar cantidad de notas
                                    6. Adicionar nota en posición determinada
                                    7. Modificar nota
                                    8. Salir del menu
                                    Ingrese una opción:
                                    """);
                            int menuN = scanner.nextInt();
                            scanner.nextLine();
                            switch (menuN) {
                                // Agregar nota
                                case 1 -> {
                                    System.out.print("Ingrese el título de la nota: ");
                                    String title = scanner.nextLine();
                                    System.out.print("Ingrese la nota: ");
                                    String content = scanner.nextLine();
                                    System.out.print("Ingrese el nombre de la asignatura: ");
                                    String subject = scanner.nextLine();
                                    if (diaryManager.addNoteToSubject(title, content, subject)) {
                                        System.out.println("Nota agregada correctamente.");
                                    } else {
                                        System.out.println("No se encontró una asignatura con ese nombre.");
                                    }
                                }
                                // Eliminar nota
                                case 2 -> {
                                    System.out.print("Ingrese el título de la nota a eliminar: ");
                                    String titleToRemove = scanner.nextLine();
                                    System.out.print("Ingrese el nombre de la asignatura: ");
                                    String subject = scanner.nextLine();
                                    if (diaryManager.removeNoteFromSubject(titleToRemove, subject)) {
                                        System.out.println("Nota eliminada correctamente.");
                                    } else {
                                        System.out.println("No se encontró una nota con ese título o asignatura.");
                                    }
                                }
                                // Consultar nota por título
                                case 3 -> {
                                    System.out.print("Ingrese el título de la nota a consultar: ");
                                    String titleToConsult = scanner.nextLine();
                                    System.out.print("Ingrese el nombre de la asignatura: ");
                                    String subject = scanner.nextLine();
                                    Note noteToConsult = diaryManager.getNoteByTitleAndSubject(titleToConsult, subject);
                                    if (noteToConsult != null) {
                                        System.out.printf("""
                                                Título: %s
                                                Contenido: %s
                                                """, noteToConsult.getTitle(), noteToConsult.getNote());
                                    } else {
                                        System.out.println("No se encontró una nota con ese título o asignatura.");
                                    }
                                }
                                // Mostrar todas las notas
                                case 4 -> {
                                    System.out.print("Ingrese el nombre de la asignatura: ");
                                    String subject = scanner.nextLine();
                                    ArrayList<Note> allNotes = diaryManager.getAllNotesBySubject(subject);
                                    if (allNotes.isEmpty()) {
                                        System.out.println("No hay notas en la asignatura.");
                                    } else {
                                        System.out.println("Notas en la asignatura:");
                                        for (Note n : allNotes) {
                                            System.out.printf("""
                                                    Título: %s
                                                    Contenido: %s
                                                    --------------------
                                                    """, n.getTitle(), n.getNote());
                                        }
                                    }
                                }
                                // Consultar cantidad de notas
                                case 5 -> {
                                    System.out.print("Ingrese el nombre de la asignatura: ");
                                    String subject = scanner.nextLine();
                                    System.out.println(diaryManager.getSizeOfNotesBySubject(subject));
                                }
                                // Adicionar nota en una posición determinada
                                case 6 -> {
                                    System.out.print("Ingrese el título de la nota a adicionar: ");
                                    String titleToAdd = scanner.nextLine();
                                    System.out.print("Ingrese la nota a adicionar: ");
                                    String contentToAdd = scanner.nextLine();
                                    System.out.print("Ingrese el nombre de la asignatura: ");
                                    String subject = scanner.nextLine();
                                    System.out.print("Ingrese la posición en la que desea adicionar la nota: ");
                                    int position = scanner.nextInt();
                                    scanner.nextLine();
                                    if (diaryManager.addNoteAtPositionInSubject(titleToAdd, contentToAdd, subject, position)) {
                                        System.out.println("Nota adicionada correctamente.");
                                    } else {
                                        System.out.println("No se encontró una asignatura con ese nombre.");
                                    }
                                }
                                // Modificar nota
                                case 7 -> {
                                    System.out.print("Ingrese el título de la nota a modificar: ");
                                    String titleToModify = scanner.nextLine();
                                    System.out.print("Ingrese el nombre de la asignatura: ");
                                    String subject = scanner.nextLine();
                                    Note noteToModify = diaryManager.getNoteByTitleAndSubject(titleToModify, subject);
                                    if (noteToModify != null) {
                                        System.out.print("Ingrese la nueva nota: ");
                                        String newContent = scanner.nextLine();
                                        diaryManager.modifyNoteContent(noteToModify, newContent);
                                        System.out.println("Nota modificada correctamente.");
                                    } else {
                                        System.out.println("No se encontró una nota con ese título o asignatura.");
                                    }
                                }
                                // Salir
                                case 8 -> exitNotesMenu = true;
                                default -> System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                            }
                        }
                    }
                }
                case 4-> exit=true;
                default -> System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        }
        System.out.println("¡Hasta luego!");
    }
}