package org.example._20260726_probaprojectkonyvnyilvantarto.services;

import org.example._20260726_probaprojectkonyvnyilvantarto.models.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public BookService() {
        fillInitialData();
    }

    public void fillInitialData() {
        books = List.of(
                new Book("George Orwell", "1984", 1949),
                new Book("J.R.R. Tolkien", "The Hobbit", 1937),
                new Book("Harper Lee", "To Kill a Mockingbird", 1960),
                new Book("F. Scott Fitzgerald", "The Great Gatsby", 1925),
                new Book("Jane Austen", "Pride and Prejudice", 1813),
                new Book("Aldous Huxley", "Brave New World", 1932),
                new Book("Frank Herbert", "Dune", 1965),
                new Book("J.K. Rowling", "Harry Potter and the Philosopher's Stone", 1997),
                new Book("Dan Brown", "The Da Vinci Code", 2003),
                new Book("Andy Weir", "The Martian", 2011)
        );
        books = new ArrayList<>(books);
    }

    public void get() {
    }
}
