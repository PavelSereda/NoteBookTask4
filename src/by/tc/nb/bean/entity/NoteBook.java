package by.tc.nb.bean.entity;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class NoteBook implements Serializable {
    private Set<Note> notes = new HashSet<Note>();
    private Set<Note> detectednotes = new HashSet<Note>();

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }

    public Set<Note> getNotes() {
        return notes;
    }

    public Set<Note> getDetectednotes() {
        return detectednotes;
    }

    public void addNote(Note newNote) {
        notes.add(newNote);
        System.out.println("Note was added");
    }

    public Set<Note> findNotesByContent(String note) {
        if (detectednotes.size() != 0) {
            detectednotes.clear();
        }
        for (Note n : notes) {
            if (n.getNote().toUpperCase().contains(note.toUpperCase())) {
                detectednotes.add(n);
            }
        }
        return detectednotes;
    }

    public Set<Note> findNotesByDate(String date) {
        if (detectednotes.size() != 0) {
            detectednotes.clear();
        }
        for (Note n : notes) {
            if (n.getDateStr().equals(date)) {
                detectednotes.add(n);
            }
        }
        return detectednotes;
    }

    //Cut notes from memory to file.
    public String writeNotebookInFile(String path) throws IOException, ClassNotFoundException {

        try {
            loadNoteBookFromFile(path);// сначала десериализуем файл и считаем то, что там записано
            // для последующей дозаписи
            FileOutputStream writer = new FileOutputStream(path, false);
            ObjectOutputStream oos = new ObjectOutputStream(writer);
            oos.writeObject(notes);
            notes.clear();//delete recorded files from the memory
            oos.flush();
            oos.close();
            System.out.println("File created");
        } catch (IOException ex) {
            System.out.println("Incorrect path");
            return "Incorrect path";
        }

        System.out.println("Completed");
        return "Completed";
    }

    public String loadNoteBookFromFile(String path) throws IOException, ClassNotFoundException {
        String resultMessage = "File doesn't exist";

        try {
            FileInputStream reader = new FileInputStream(path);
            ObjectInputStream oin = new ObjectInputStream(reader);
            //setNotes((List<Note>) oin.readObject());

            for (Note i : (Set<Note>) oin.readObject()) {
                notes.add(i);
            }

            resultMessage = "File was loaded.";
            //System.out.println(resultMessage);
            return resultMessage;
        } catch (FileNotFoundException ex) {
            System.out.println(resultMessage);
            return resultMessage;
        }
    }


}
