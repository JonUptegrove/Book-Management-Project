package org.se4940project.library_manager.controller;

import org.se4940project.library_manager.model.Book;
import org.se4940project.library_manager.model.Cart;
import org.se4940project.library_manager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.Map;

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
            BigDecimal subtotal = BigDecimal.ZERO;

            for (Book book : cart.getBooks()) {

                int quantity = cart.getQuantity(book.getId());

                BigDecimal bookTotal = book.getPrice()
                        .multiply(BigDecimal.valueOf(quantity));

                subtotal = subtotal.add(bookTotal);
            }

            BigDecimal shippingCost = BigDecimal.ZERO;

            BigDecimal orderTotal = subtotal.add(shippingCost);

            model.addAttribute("cartBooks", cart.getBooks());
            model.addAttribute("quantities", cart.getQuantities());

            model.addAttribute("subtotal", subtotal);
            model.addAttribute("shippingCost", shippingCost);
            model.addAttribute("orderTotal", orderTotal);

            return "cart";
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

    // Change the quantity of a book
    @PostMapping("/quantity/{id}")
    public String updateQuantity(
            @PathVariable Long id,
            @RequestParam int quantity) {

        cart.setQuantity(id, quantity);

        return "redirect:/cart";
    }
    // Navigate to payment page
    @GetMapping("/payment")
    public String payment(Model model) {

        BigDecimal subtotal = BigDecimal.ZERO;

        for (Book book : cart.getBooks()) {

            int quantity = cart.getQuantity(book.getId());

            subtotal = subtotal.add(
                    book.getPrice().multiply(BigDecimal.valueOf(quantity))
            );
        }

        if (cart.getBooks().isEmpty()) {
            return "redirect:/cart";
        }

        BigDecimal shippingCost = BigDecimal.ZERO;
        BigDecimal orderTotal = subtotal.add(shippingCost);

        model.addAttribute("subtotal", subtotal);
        model.addAttribute("shippingCost", shippingCost);
        model.addAttribute("orderTotal", orderTotal);

        return "payment";
    }
    @PostMapping("/purchase")
    public String completePurchase() {

        // Prevent purchasing with an empty cart
        if (cart.getBooks().isEmpty()) {
            return "redirect:/cart";
        }

        // Clear the session cart
        cart.clear();

        // Display confirmation page
        return "redirect:/cart/confirmation";
    }


    @GetMapping("/confirmation")
    public String showConfirmation() {
        return "confirmation";
    }
}
