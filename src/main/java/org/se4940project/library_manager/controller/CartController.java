package org.se4940project.library_manager.controller;

import org.se4940project.library_manager.model.Book;
import org.se4940project.library_manager.model.Cart;
import org.se4940project.library_manager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private Cart cart;

    @Autowired
    private BookService bookService;

    // View the cart webpage
    @GetMapping
    public String viewCart(Model model) {
        model.addAttribute("cartBooks", cart.getBooks());
        return "cart"; // Looks for cart.html
    }

    // Add a book to the cart
    @PostMapping("/add/{id}")
    public String addToCart(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            cart.addBook(book);
        }
        return "redirect:/books";
    }

    // Remove a book from the cart
    @PostMapping("/remove/{id}")
    public String removeFromCart(@PathVariable Long id) {
        cart.removeBook(id);
        return "redirect:/cart";
    }

    // Clear all books from the cart
    @PostMapping("/clear")
    public String clearCart() {
        cart.clear();
        return "redirect:/cart";
    }
}
