package by.tc.nb.bean.entity;

import java.io.Serializable;

public class Note implements Serializable {

    private String note;
    private String dateStr;

    public Note(String note, String dateStr) {
        this.note = note;
        this.dateStr = dateStr;
    }

    public Note(String note) {
        this.note = note;
    }

    public Note() {
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note1 = (Note) o;

        if (note != null ? !note.equals(note1.note) : note1.note != null) return false;
        return dateStr != null ? dateStr.equals(note1.dateStr) : note1.dateStr == null;

    }

    @Override
    public int hashCode() {
        int result = note != null ? note.hashCode() : 0;
        result = 31 * result + (dateStr != null ? dateStr.hashCode() : 0);
        return result;
    }
}
