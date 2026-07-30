package org.example._20260730_serveroldalikonyvnyilvantarto.repositories;


import org.example._20260730_serveroldalikonyvnyilvantarto.models.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Primary
@Component
public class BookListRepository implements BookRepository {
    List<Book> books;

    public BookListRepository() {
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


    @Override
    public <S extends Book> S save(S entity) {
        this.books.add(entity);
        return entity;
    }

    @Override
    public List<Book> findAll() {
        return this.books;
    }

    private void deleteBookHelper(int id) {
        Book book = books.stream()
                .filter(p -> p.getId() == id)
                .findFirst().get();
        books.remove(book);
    }

    @Override
    public void modifyBook(Integer id, String author,
                    String title, Integer releaseYear) {

        deleteBookHelper(id);
        save(new Book(id, author, title, releaseYear));
    }

    @Override
    public void deleteById(Integer id) {
        deleteBookHelper(id);
    }
}
