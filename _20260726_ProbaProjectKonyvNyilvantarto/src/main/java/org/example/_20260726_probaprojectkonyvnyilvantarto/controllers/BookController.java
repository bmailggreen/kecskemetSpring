package org.example._20260726_probaprojectkonyvnyilvantarto.controllers;


import org.example._20260726_probaprojectkonyvnyilvantarto.models.Book;
import org.example._20260726_probaprojectkonyvnyilvantarto.models.BookId;
import org.example._20260726_probaprojectkonyvnyilvantarto.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/addBook")
    public String addBook(Book book) {
//        book.fixId();
        bookService.getBooks().add(book);
//        bookService.getBooks().add(book);
//        return "redirect:/redirectShowBooks";
        return "index";
    }

    private void deleteBook(int id) {
        Book book = bookService.getBooks().stream()
                .filter(p -> p.getId() == id)
                .findFirst().get();
        bookService.getBooks().remove(book);
    }

    @PostMapping("/modifyBook")
    public String modifyBook(Book book) {
        int id = book.getId();
        deleteBook(id);
        bookService.getBooks().add(book);
        return "index";
    }

    @PostMapping("/deleteBook")
    public String deleteBook(BookId bookId) {
        int id = bookId.getId();
        deleteBook(id);
        return "index";
    }

    @GetMapping("/")
    public String mainPage() {
        return "index";
    }

}
