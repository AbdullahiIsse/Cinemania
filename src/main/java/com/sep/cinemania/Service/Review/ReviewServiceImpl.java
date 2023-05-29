package com.sep.cinemania.Service.Review;

import com.sep.cinemania.Dao.Review.ReviewJoinRepository;
import com.sep.cinemania.Dao.Review.ReviewRepository;
import com.sep.cinemania.Entities.Review;
import com.sep.cinemania.Entities.ReviewJoinUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;
    private final ReviewJoinRepository reviewJoinRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, ReviewJoinRepository reviewJoinRepository) {
        this.reviewRepository = reviewRepository;
        this.reviewJoinRepository = reviewJoinRepository;
    }

    @Override
    public List<ReviewJoinUser> getReviewByMovieId(long movieId) {
        return reviewJoinRepository.getReviewByMovieId(movieId);
    }

    @Override
    public List<Review> getReviewByUserId(String userId) {
        return reviewRepository.getReviewByUserId(userId);
    }

    @Override
    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review getReviewByUserIdAndId(String userId, long id) {
        return reviewRepository.getReviewByUserIdAndId(userId, id);
    }

    @Override
    public float getAverageRatingByMovieId(long movieId) {
        return reviewRepository.getAverageRatingByMovieId(movieId);
    }

    @Override
    public long countAllByMovieId(long movieId) {
        return reviewRepository.countAllByMovieId(movieId);
    }

    @Override
    public void deleteByUserIdAndId(String userId, long id) {
        reviewRepository.deleteByUserIdAndId(userId, id);
    }
}
