package dev.practice.springbootlibrary.controller;

import dev.practice.springbootlibrary.entity.Book;
import dev.practice.springbootlibrary.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @PutMapping("/secure/checkout")
    public Book checkoutBook(@RequestParam Long bookId) throws Exception {
        String userEmail = "tester@tester.com";
        return bookService.checkoutBook(userEmail, bookId);
    }

    @GetMapping("/secure/is-checked-out/by-user")
    public boolean checkoutBookByUser(@RequestParam Long bookId) {
        String userEmail = "tester@tester.com";
        return bookService.checkoutByUser(userEmail, bookId);
    }

    @GetMapping("/secure/current-loans/count")
    public int currentLoansCount() {
        String userEmail = "tester@tester.com";
        return bookService.currentLoansCount(userEmail);
    }
}
