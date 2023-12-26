package dev.practice.springbootlibrary.service;

import dev.practice.springbootlibrary.dao.ReviewRepository;
import dev.practice.springbootlibrary.entity.Review;
import dev.practice.springbootlibrary.requestModels.ReviewRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;


@Service
@Transactional
@AllArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public void postReview(String userEmail, ReviewRequest reviewRequest) throws  Exception {
        Review validateReview = reviewRepository
                .findByUserEmailAndBookId(userEmail, reviewRequest.getBookId());
        if(validateReview != null) {
            throw new Exception("Review already created");
        }
        Review review = new Review();
        review.setBookId(reviewRequest.getBookId());
        review.setRating(reviewRequest.getRating());
        review.setUserEmail(userEmail);
        if(reviewRequest.getReviewDescription() != null) {
            review.setReviewDescription(reviewRequest.getReviewDescription());
        }
        review.setDate(Date.valueOf(LocalDate.now()));
        reviewRepository.save(review);
    }

    public boolean userReviewListed(String userEmail, Long bookId) {
         Review validateReview = reviewRepository.findByUserEmailAndBookId(userEmail, bookId);
         return validateReview != null;
    }

}
