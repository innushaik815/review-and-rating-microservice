package com.example.reviewandratings.controller;
import com.example.reviewandratings.domain.Review;
import com.example.reviewandratings.services.IReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reviews")
@CrossOrigin(origins ="http://localhost:4200")
public class ReviewController {

    private final IReviewService reviewService;

    public ReviewController(IReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable long reviewId) {
        Review review = reviewService.getReviewById(reviewId);
        if (review != null) {
            return ResponseEntity.ok(review);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/{userEmail}")
    public ResponseEntity<List<Review>> getReviewsByUserEmail(@PathVariable String userEmail) {
        List<Review> reviews = reviewService.getReviewsByUserEmail(userEmail);
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Review>> getReviewsByRestaurantId(@PathVariable String restaurantId) {
        List<Review> reviews = reviewService.getReviewsByRestaurantId(restaurantId);
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/rating/greater-than/{rating}")
    public ResponseEntity<List<Review>> getReviewsWithRatingGreaterThan(@PathVariable int rating) {
        List<Review> reviews = reviewService.getReviewsWithRatingGreaterThan(rating);
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/rating/less-than/{rating}")
    public ResponseEntity<List<Review>> getReviewsWithRatingLessThan(@PathVariable int rating) {
        List<Review> reviews = reviewService.getReviewsWithRatingLessThan(rating);
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/time-period/{startDate}/{endDate}")
    public ResponseEntity<List<Review>> getReviewsBetweenTimePeriod(@PathVariable Date startDate, @PathVariable Date endDate) {
        List<Review> reviews = reviewService.getReviewsBetweenTimePeriod(startDate, endDate);
        return ResponseEntity.ok(reviews);
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review createdReview = reviewService.createReview(review);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReview);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<Review> updateReview(@PathVariable long reviewId, @RequestBody Review review) {
        Review existingReview = reviewService.getReviewById(reviewId);
        if (existingReview != null) {
            review.setReviewId(reviewId);
            Review updatedReview = reviewService.updateReview(review);
            return ResponseEntity.ok(updatedReview);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable long reviewId) {
        reviewService.deleteReview(reviewId);
        return ResponseEntity.noContent().build();
    }
}
