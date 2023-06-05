package com.example.reviewandratings.services;

import com.example.reviewandratings.domain.Review;

import java.util.Date;
import java.util.List;

public interface IReviewService {
    Review getReviewById(long reviewId);

    List<Review> getReviewsByUserEmail(String userEmail);

    List<Review> getReviewsByRestaurantId(String restaurantId);

    List<Review> getReviewsWithRatingGreaterThan(int rating);

    List<Review> getReviewsWithRatingLessThan(int rating);

    List<Review> getReviewsBetweenTimePeriod(Date startDate, Date endDate);

    Review createReview(Review review);

    Review updateReview(Review review);

    void deleteReview(long reviewId);
}
