package entity;


import by.tc.nb.bean.entity.Note;
import by.tc.nb.bean.entity.NoteBook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class FindNotesTest {
    NoteBook n = new NoteBook();

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
    public void testFindNotesByContent(Set<Note> list) throws Exception {
        n.setNotes(list);
        Note nn = new Note("aaaaa", "aaaaa");
        n.findNotesByContent(nn.getNote());
        Assert.assertEquals(n.getDetectednotes().size(), 2);
    }


    @Test(dataProvider = "dp")
    public void testFindNotesByDate(Set<Note> list) throws Exception {
        n.setNotes(list);
        Note nn = new Note(null, "26.09.2011");
        n.findNotesByDate(nn.getDateStr());
        Assert.assertEquals(n.getDetectednotes().size(), 1);
    }

}