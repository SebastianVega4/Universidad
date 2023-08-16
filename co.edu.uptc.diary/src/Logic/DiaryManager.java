package Logic;

import Model.Note;

import java.util.ArrayList;
import java.util.Iterator;

public class DiaryManager {
    private final ArrayList<String> subjects;
    private final ArrayList<ArrayList<Note>> notes;

    public DiaryManager() {
        subjects = new ArrayList<>();
        notes = new ArrayList<>();
    }

    public void addSubject(String subject) {
        subjects.add(subject);
        notes.add(new ArrayList<>());
    }

    public boolean removeSubject(String subject) {
        int index = subjects.indexOf(subject);
        System.out.println(subjects.indexOf(subject));
        if (index != -1) {
            subjects.remove(index);
            notes.remove(index);
            return true;
        }
        return false;
    }
    public boolean getVerificSubject(String subject){
        System.out.println(subjects.contains(subject));
        return subjects.contains(subject);
    }
    public boolean addNoteToSubject(String title, String content, String subject) {
        int index = subjects.indexOf(subject);
        if (index != -1) {
            Note note = new Note(title, content);
            notes.get(index).add(note);
            return true;
        }
        return false;
    }

    public boolean removeNoteFromSubject(String title, String subject) {
        int index = subjects.indexOf(subject);
        if (index != -1) {
            ArrayList<Note> subjectNotes = notes.get(index);
            Iterator<Note> iterator = subjectNotes.iterator();
            while (iterator.hasNext()) {
                Note note = iterator.next();
                if (note.getTitle().equals(title)) {
                    iterator.remove();
                    return true;
                }
            }
        }
        return false;
    }

    public Note getNoteByTitleAndSubject(String title, String subject) {
        int index = subjects.indexOf(subject);
        if (index != -1) {
            ArrayList<Note> subjectNotes = notes.get(index);
            for (Note note : subjectNotes) {
                if (note.getTitle().equals(title)) {
                    return note;
                }
            }
        }
        return null;
    }

    public ArrayList<Note> getAllNotesBySubject(String subject) {
        int index = subjects.indexOf(subject);
        if (index != -1) {
            return notes.get(index);
        }
        return new ArrayList<>();
    }

    public String getSizeOfNotesBySubject(String subject) {
        int index = subjects.indexOf(subject);
        if (index != -1) {
            return "Cantidad de notas en la asignatura " + subject + ": " + notes.get(index).size();
        }
        return "No se encontró una asignatura con ese nombre.";
    }

    public boolean addNoteAtPositionInSubject(String title, String content, String subject, int position) {
        int index = subjects.indexOf(subject);
        if (index != -1) {
            ArrayList<Note> subjectNotes = notes.get(index);
            if (position >= 0 && position <= subjectNotes.size()) {
                Note note = new Note(title, content);
                subjectNotes.add(position, note);
                return true;
            }
        }
        return false;
    }

    public void modifyNoteContent(Note note, String newContent) {
        note.setNote(newContent);
    }

    public ArrayList<String> getSubjects() {
        return subjects;
    }
}