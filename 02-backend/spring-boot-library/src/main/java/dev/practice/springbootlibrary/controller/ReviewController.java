package dev.practice.springbootlibrary.controller;

import dev.practice.springbootlibrary.requestModels.ReviewRequest;
import dev.practice.springbootlibrary.service.ReviewService;
import dev.practice.springbootlibrary.utils.ExtractJWT;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/reviews")
@AllArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/secure")
    public void postReview(@RequestHeader(value = "Authorization") String token,
                           @RequestBody ReviewRequest reviewRequest)
            throws Exception {
        String userEmail = ExtractJWT.payloadJWTExtraction(token);
        if (userEmail == null) {
            throw new Exception("user Email is missing");
        }
        reviewService.postReview(userEmail, reviewRequest);
    }

    @GetMapping("/secure/user/book")
    public Boolean reviewBookByUser(@RequestHeader(value = "Authorization") String token,
                                    @RequestParam Long bookId) throws Exception {
        String userEmail = ExtractJWT.payloadJWTExtraction(token);
        if (userEmail == null) {
            throw new Exception("user Email is missing");
        }
        return reviewService.userReviewListed(userEmail, bookId);
    }
}
