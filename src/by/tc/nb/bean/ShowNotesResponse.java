package by.tc.nb.bean;


import by.tc.nb.bean.entity.Note;

import java.util.Set;

public class ShowNotesResponse extends Response {
    private Set<Note> notes;

    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }
}
