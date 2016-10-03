package by.tc.nb.bean;

import by.tc.nb.bean.entity.Note;

import java.util.Set;


public class FindNotesResponse extends Response {
     private Set<Note> detectednotes;

    public Set<Note> getDetectednotes() {
        return detectednotes;
    }

    public void setDetectednotes(Set<Note> detectednotes) {
        this.detectednotes = detectednotes;
    }
}
