package org.example._20260730_serveroldalikonyvnyilvantarto.controllers;


import org.example._20260730_serveroldalikonyvnyilvantarto.models.Book;
import org.example._20260730_serveroldalikonyvnyilvantarto.models.BookId;
import org.example._20260730_serveroldalikonyvnyilvantarto.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = {"null", "*"})
//@CrossOrigin(origins = "*")
public class BookController {
    @Autowired
    BookService bookService;


    @PostMapping("/addBook")
    public String addBook(@RequestParam(name = "author") String author,
                                        @RequestParam(name = "title") String title,
                                        @RequestParam(name = "releaseYear") Integer releaseYear) {
//        bookService.getBooks().add(new Book(author, title, releaseYear));
        bookService.save(new Book(author, title, releaseYear));
        return "";
    }

    @PutMapping("/modifyBook")
    public String modifyBook(@RequestParam(name = "id") Integer id,
                             @RequestParam(name = "author") String author,
                             @RequestParam(name = "title") String title,
                             @RequestParam(name = "releaseYear") Integer releaseYear) {

        bookService.modifyBook(id, author, title, releaseYear);
        return "";
    }

    @DeleteMapping("/deleteBook")
    public String deleteBook(@RequestParam(name = "id") Integer id) {
        bookService.deleteById(id);
        return "";
    }

    @GetMapping("/getBooks")
    public List<Book> getBooks() {
        return bookService.findAll();
    }
}
