package Logic;

import Model.Note;

import java.util.ArrayList;

public class DiaryManager {
    private final ArrayList<Note> diary;

    public DiaryManager() {
        diary = new ArrayList<>();
    }

    public String addNote(String title, String  content) {
        Note note = new Note( title, content);
        diary.add(note);
        return "Nota agregada correctamente.";
    }

    public String removeNote(Note note) {
        diary.remove(note);
        return"Nota eliminada correctamente.";
    }

    public Note getNoteByTitle(String title) {
        for (Note note : diary) {
            if (note.getTitle().equals(title)) {
                return note;
            }
        }
        return null;
    }

    public ArrayList<Note> getAllNotes() {
        return diary;
    }

    public String getSizeOfNotes() {
        return "Cantidad de notas en la agenda:" + diary.size();
    }

    public String addNoteAtPosition(Note note, int position) {
        diary.add(position, note);
        return "Nota adicionada correctamente.";
    }

    public String modifyNoteContent(Note note, String newContent) {
        note.setNote(newContent);
        return "Nota modificada correctamente.";
    }
}