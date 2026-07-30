package org.example._20260730_serveroldalikonyvnyilvantarto.repositories;

import org.example._20260730_serveroldalikonyvnyilvantarto.models.Book;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository {
    <S extends Book> S save(S entity);
    List<Book> findAll();
    void modifyBook(Integer id, String author,
                    String title, Integer releaseYear);
    void deleteById(Integer id);
}
