package dev.practice.springbootlibrary.requestModels;

import lombok.Data;

import java.util.Optional;

@Data
public class ReviewRequest {
    private double rating;
    private Long bookId;
    private String reviewDescription;
}