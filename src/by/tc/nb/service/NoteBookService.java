package by.tc.nb.service;


import by.tc.nb.bean.entity.Note;
import by.tc.nb.service.exception.ServiceException;

import java.io.IOException;
import java.util.Set;

public interface NoteBookService {

    void addNote(String note, String date) throws ServiceException;

    Set<Note> findNotesByContent(String note) throws ServiceException;

    Set<Note> findNotesByDate(String date) throws ServiceException;

    String writeNotebookInFile(String path) throws ServiceException, IOException, ClassNotFoundException;

    String loadNoteBookFromFile(String path) throws ServiceException, IOException, ClassNotFoundException;

    Set<Note> showNotes() throws ServiceException, IOException;

}
