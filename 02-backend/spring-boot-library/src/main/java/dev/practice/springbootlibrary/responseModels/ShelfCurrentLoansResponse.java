package dev.practice.springbootlibrary.responseModels;

import dev.practice.springbootlibrary.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShelfCurrentLoansResponse {
    private Book book;
    private int daysLeft;





}
