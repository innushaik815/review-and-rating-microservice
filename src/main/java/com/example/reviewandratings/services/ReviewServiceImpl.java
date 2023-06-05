package com.example.reviewandratings.services;

import com.example.reviewandratings.domain.Review;
import com.example.reviewandratings.repo.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewServiceImpl implements IReviewService{

    private final ReviewRepository reviewRepository;
    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review getReviewById(long reviewId) {
        return reviewRepository.findByReviewId(reviewId).orElse(null);
    }

    @Override
    public List<Review> getReviewsByUserEmail(String userEmail) {
        return reviewRepository.findByUserEmail(userEmail);
    }

    @Override
    public List<Review> getReviewsByRestaurantId(String restaurantId) {
        return reviewRepository.findByRestaurantId(restaurantId);
    }

    @Override
    public List<Review> getReviewsWithRatingGreaterThan(int rating) {
        return reviewRepository.findByRatingGreaterThan(rating);
    }

    @Override
    public List<Review> getReviewsWithRatingLessThan(int rating) {
        return reviewRepository.findByRatingLessThan(rating);
    }

    @Override
    public List<Review> getReviewsBetweenTimePeriod(Date startDate, Date endDate) {
        return reviewRepository.findByTimeStampBetween(startDate, endDate);
    }


    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public void deleteReview(long reviewId) {
        reviewRepository.deleteByReviewId(reviewId);
    }

}
