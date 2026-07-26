package org.example._20260726_probaprojectkonyvnyilvantarto.controllers;

import org.example._20260726_probaprojectkonyvnyilvantarto.models.Book;
import org.example._20260726_probaprojectkonyvnyilvantarto.models.BookId;
import org.example._20260726_probaprojectkonyvnyilvantarto.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RedirectController {
    @Autowired
    BookService bookService;

    @PostMapping("/redirectNewBook")
    private String redirectNewBook(/*Model model*/) {
//        model.addAttribute("book", new Book());
        return "newbook";
    }

    @PostMapping("/redirectShowBooks")
    private String redirectShowBooks(Model model) {
        model.addAttribute("books", bookService.getBooks());
        return "showbooks";
    }


    @PostMapping("/redirectModifyBook")
    private String redirectModifyBook(Model model, BookId bookId) {
        model.addAttribute("book",
                bookService.getBooks().stream()
                        .filter(p -> p.getId() == bookId.getId())
                        .findFirst().get());
        return "modifybook";
    }

    @PostMapping("/redirectMainMenu")
    private String redirectMainMenu() {
        return "index";
    }

}
