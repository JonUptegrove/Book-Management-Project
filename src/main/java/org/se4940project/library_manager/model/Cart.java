package org.se4940project.library_manager.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {
    final private List<Book> cartBooks = new ArrayList<>();

    public void addBook(Book book) {
        // Avoid adding duplicate entries if already in cart
        if (cartBooks.stream().noneMatch(b -> b.getId().equals(book.getId()))) {
            cartBooks.add(book);
        }
    }

    public void removeBook(Long bookId) {
        cartBooks.removeIf(book -> book.getId().equals(bookId));
    }

    public List<Book> getBooks() {
        return cartBooks;
    }

    public void clear() {
        cartBooks.clear();
    }
}
