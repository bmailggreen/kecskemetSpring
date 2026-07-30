package org.example._20260730_serveroldalikonyvnyilvantarto.services;

import org.example._20260730_serveroldalikonyvnyilvantarto.models.Book;
import org.example._20260730_serveroldalikonyvnyilvantarto.repositories.BookDatabaseRepository;
import org.example._20260730_serveroldalikonyvnyilvantarto.repositories.BookListRepository;
import org.example._20260730_serveroldalikonyvnyilvantarto.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

//    BookRepository bookRepository;

//    BookRepository bookRepository = new BookListRepository();


/*
    public BookService(BookDatabaseRepository bdr) {
        bookRepository = bdr;
    }
*/

    public <S extends Book> S save(S entity) {
        return bookRepository.save(entity);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public void modifyBook(Integer id, String author,
                    String title, Integer releaseYear) {
        bookRepository.modifyBook(id, author, title, releaseYear);
    }

    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }
}
