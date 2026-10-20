package org.se4940project.library_manager.controller;

import org.se4940project.library_manager.model.Book;
import org.se4940project.library_manager.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/books")
public class BookController {

    final
    BookRepository bookRepo;

    public BookController(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    // handle book display
    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookRepo.findAll());
        model.addAttribute("newBook", new Book());
        return "books"; // Looks for books.html in templates
    }
    // handle book additions
    @PostMapping
    public String saveBook(@ModelAttribute Book book) {
        bookRepo.save(book);
        return "redirect:/books";
    }
}
