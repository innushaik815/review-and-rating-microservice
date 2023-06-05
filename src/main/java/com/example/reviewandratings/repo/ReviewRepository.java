package com.example.reviewandratings.repo;

import com.example.reviewandratings.domain.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends MongoRepository<Review,Long> {
    // Find review by reviewId
    Optional<Review> findByReviewId(long reviewId);

    // Find reviews by userEmail
    List<Review> findByUserEmail(String userEmail);

    // Find reviews by restaurantId
    List<Review> findByRestaurantId(String restaurantId);

    // Find reviews by rating greater than a specified value
    List<Review> findByRatingGreaterThan(int rating);

    // Find reviews by rating less than a specified value
    List<Review> findByRatingLessThan(int rating);

    // Find reviews by timestamp between a start and end date
    List<Review> findByTimeStampBetween(Date startDate, Date endDate);

    // Save or update a review
    Review save(Review review);

    // Delete a review by reviewId
    void deleteByReviewId(long reviewId);
}
