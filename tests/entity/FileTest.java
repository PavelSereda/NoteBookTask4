package entity;

import by.tc.nb.bean.entity.Note;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.service.impl.NoteBookServiceImpl;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.*;


public class FileTest {

    private final String path = "D:\\notebook.txt";
    private final String incorrectPath = "wrfqwefw";

    @Test
    public void testWriteNotebookInFile() throws Exception {
        NoteBookServiceImpl n = new NoteBookServiceImpl();
        Assert.assertEquals(n.writeNotebookInFile(path), "Completed");
        // Assert.assertEquals(n.writeNotebookInFile(incorrectPath), "Incorrect path");
    }

    @Test
    public void LoadNotebookFromFile() throws Exception {
        NoteBookServiceImpl n = new NoteBookServiceImpl();
        Assert.assertEquals(n.loadNoteBookFromFile(path), "File was loaded.");
        // Assert.assertEquals(n.loadNoteBookFromFile(incorrectPath), "File doesn't exist");
    }

    @DataProvider(name = "dp")
    public Object[][] createSomeData() {
        Set<Note> list = new HashSet<>();
        list.add(new Note("aaaaaaaaa", "25.09.2011"));
        list.add(new Note("aaaaaaaaaaaa", "26.09.2011"));
        list.add(new Note("25.09.2011", "aaaaaaaaa"));
        return new Object[][]{
                {list},
        };
    }

    @Test(dataProvider = "dp")
    public void testRecordFile(Set<Note> list) throws Exception {
        NoteBook n = new NoteBook();
        n.setNotes(list);
        n.writeNotebookInFile(path);
        Assert.assertEquals(n.getDetectednotes().size(), 0);
    }








}