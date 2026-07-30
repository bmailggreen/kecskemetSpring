package org.example._20260730_serveroldalikonyvnyilvantarto.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
//    @GeneratedValue
    Integer id;

    String author;
    String title;
    Integer releaseYear;

    static private int nextValidId = 1;

    public Book() {
        this.id = nextValidId++;
    }

    public Book(String author, String title, Integer releaseYear) {
        this.id = nextValidId++;
        this.author = author;
        this.title = title;
        this.releaseYear = releaseYear;
    }

    public Book(Integer id, String author, String title, Integer releaseYear) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.releaseYear = releaseYear;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    //Hacked fix
    public void fixId() {
        this.id = nextValidId++;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    /*
    public static int getNextValidId() {
        return nextValidId;
    }

    public static void setNextValidId(int nextValidId) {
        Book.nextValidId = nextValidId;
    }
     */

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }
}
