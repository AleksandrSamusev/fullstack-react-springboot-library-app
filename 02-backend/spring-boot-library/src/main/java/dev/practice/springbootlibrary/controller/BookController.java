package dev.practice.springbootlibrary.controller;

import dev.practice.springbootlibrary.entity.Book;
import dev.practice.springbootlibrary.service.BookService;
import dev.practice.springbootlibrary.utils.ExtractJWT;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @PutMapping("/secure/checkout")
    public Book checkoutBook(@RequestParam Long bookId,
                             @RequestHeader(value = "Authorization") String token) throws Exception {
        String userEmail = ExtractJWT.payloadJWTExtraction(token);
        return bookService.checkoutBook(userEmail, bookId);
    }

    @GetMapping("/secure/is-checked-out/by-user")
    public boolean checkoutBookByUser(@RequestParam Long bookId,
                                      @RequestHeader(value = "Authorization") String token) {
        String userEmail = ExtractJWT.payloadJWTExtraction(token);
        return bookService.checkoutByUser(userEmail, bookId);
    }

    @GetMapping("/secure/current-loans/count")
    public int currentLoansCount(@RequestHeader(value = "Authorization") String token) {
        String userEmail = ExtractJWT.payloadJWTExtraction(token);
        return bookService.currentLoansCount(userEmail);
    }
}
