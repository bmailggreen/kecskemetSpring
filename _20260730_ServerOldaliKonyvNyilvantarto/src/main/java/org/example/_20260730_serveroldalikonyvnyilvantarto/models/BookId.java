package org.example._20260730_serveroldalikonyvnyilvantarto.models;

public class BookId {
    Integer id;

    public BookId() {
    }

    public BookId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BookId{" +
                "id=" + id +
                '}';
    }
}
