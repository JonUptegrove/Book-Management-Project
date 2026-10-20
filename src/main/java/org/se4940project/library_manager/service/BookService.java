package org.se4940project.library_manager.service;

import org.se4940project.library_manager.model.Book;
import org.se4940project.library_manager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepo;

    // retrieve books
    public List<Book> getBooks() {
        return bookRepo.findAll();
    }
    // save or update book
    public void saveBook(Book book) {
        bookRepo.save(book);
    }
}
