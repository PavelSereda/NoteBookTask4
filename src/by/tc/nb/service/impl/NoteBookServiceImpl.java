package by.tc.nb.service.impl;


import by.tc.nb.bean.entity.Note;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.service.NoteBookService;
import by.tc.nb.service.exception.ServiceException;
import by.tc.nb.source.NoteBookProvider;

import java.io.IOException;
import java.util.Set;

public class NoteBookServiceImpl implements NoteBookService {

    NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();

    @Override
    public void addNote(String note, String date) throws ServiceException {
        if (note == null || "".equals(note)) {
            throw new ServiceException("Wrong parameter!");
        }
        Note newNote = new Note(note, date);
        noteBook.addNote(newNote);

    }

    @Override
    public Set<Note> findNotesByContent(String note) throws ServiceException {
        return noteBook.findNotesByContent(note);
    }

    @Override
    public Set<Note> findNotesByDate(String date) throws ServiceException {
        return noteBook.findNotesByDate(date);
    }

    @Override
    public String writeNotebookInFile(String path) throws ServiceException, IOException, ClassNotFoundException {
        return noteBook.writeNotebookInFile(path);
    }

    @Override
    public String loadNoteBookFromFile(String path) throws ServiceException, IOException, ClassNotFoundException {
        return noteBook.loadNoteBookFromFile(path);
    }

    @Override
    public Set<Note> showNotes() throws ServiceException, IOException {
        return noteBook.getNotes();
    }

}
