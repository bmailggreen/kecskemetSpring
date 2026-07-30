package org.example._20260730_serveroldalikonyvnyilvantarto.repositories;


import jakarta.transaction.Transactional;
import org.example._20260730_serveroldalikonyvnyilvantarto.models.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//@Primary
public interface BookDatabaseRepository
        extends JpaRepository<Book, Integer>, BookRepository {

    @Override
    <S extends Book> S save(S entity);

    @Override
    List<Book> findAll();

    @Modifying
    @Transactional
    @Query("UPDATE Book b SET b.author = :author, " +
            "b.title = :title, b.releaseYear = :releaseYear WHERE b.id = :id")
    void modifyBook(
            @Param("id") Integer id,
            @Param("author") String author,
            @Param("title") String title,
            @Param("releaseYear") Integer releaseYear
    );

    @Override
    void deleteById(Integer id);
}
