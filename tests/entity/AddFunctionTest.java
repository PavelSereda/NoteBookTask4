package entity;

import by.tc.nb.bean.entity.Note;
import by.tc.nb.service.exception.ServiceException;
import by.tc.nb.service.impl.NoteBookServiceImpl;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;


public class AddFunctionTest {
    NoteBookServiceImpl n = new NoteBookServiceImpl();


    @DataProvider(name = "dp")
    public Object[][] createSomeData() {

        return new Object[][]{
                {new Note("25.09.2011", "aaaaaaaaa"), 1},
                {new Note("15.09.2011", "aaaaafdaaaa"), 2},
                {new Note("25.49.2051", "aaaadbsaaaaa"), 3},
        };
    }

    @Test(dataProvider = "dp")
    public void testAddBySize(Note newNote, int size) throws ServiceException, IOException {
        n.addNote(newNote.getNote(), newNote.getDateStr());
        Assert.assertEquals(n.showNotes().size(), size);
    }


    @Test(expectedExceptions = ServiceException.class)
    public void testEmptyNote() throws ServiceException, IOException {
        Note empty = new Note("", "");
        n.addNote(empty.getNote(),empty.getDateStr());
    }

    @Test(dataProvider = "dp")
    public void testAddByNote(Note newNote, int size) throws ServiceException, IOException {
        NoteBookServiceImpl n = new NoteBookServiceImpl();
        n.addNote(newNote.getNote(), newNote.getDateStr());
        for (Note note : n.showNotes()) {
            Assert.assertEquals(note.getNote(), newNote.getNote());
            Assert.assertEquals(note.getDateStr(), newNote.getDateStr());
        }
    }

}