package com.sep.cinemania.Service.Review;

import com.sep.cinemania.Entities.Review;
import com.sep.cinemania.Entities.ReviewJoinUser;

import java.util.List;

public interface ReviewService {

    List<ReviewJoinUser> getReviewByMovieId(long movieId);
    List<Review>getReviewByUserId(String userId);

    Review addReview(Review review);

    Review getReviewByUserIdAndId(String userId,long id);

    float getAverageRatingByMovieId(long movieId);
    long countAllByMovieId(long movieId);

    void deleteByUserIdAndId(String userId,long id);
}
