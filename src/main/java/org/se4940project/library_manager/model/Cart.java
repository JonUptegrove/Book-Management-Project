package org.se4940project.library_manager.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {
    final private List<Book> cartBooks = new ArrayList<>();

    private final Map<Long, Integer> quantities = new HashMap<>();

    public void addBook(Book book) {
        // Avoid adding duplicate entries if already in cart
        if (cartBooks.stream().noneMatch(b -> b.getId().equals(book.getId()))) {
            cartBooks.add(book);
            quantities.put(book.getId(), 1);
        }
        else{
            Long id = book.getId();

            quantities.put(id, quantities.get(id) + 1);
        }
    }

    public void removeBook(Long bookId) {
        cartBooks.removeIf(book -> book.getId().equals(bookId));
        quantities.remove(bookId);
    }
    public void setQuantity(Long bookId, int quantity) {

        if (quantity < 1) {
            removeBook(bookId);
            return;
        }

        if (cartBooks.stream().anyMatch(book ->
                book.getId().equals(bookId))) {

            quantities.put(bookId, quantity);
        }
    }

    public int getQuantity(Long bookId) {
        return quantities.getOrDefault(bookId, 1);
    }

    public List<Book> getBooks() {
        return cartBooks;
    }

    public Map<Long, Integer> getQuantities() {
        return quantities;
    }

    public void clear() {
        cartBooks.clear();
        quantities.clear();
    }
}
