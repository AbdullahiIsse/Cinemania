package com.sep.cinemania.Dao.Review;

import com.sep.cinemania.Entities.Review;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review,Long> {

    List<Review>getReviewByUserId(String userId);
    Review getReviewByUserIdAndId(String userId,long id);

    @Query(nativeQuery = true,value = "select avg(rating) from Review where movie_id = ?1")
    float getAverageRatingByMovieId(long movieId);
    long countAllByMovieId(long movieId);

    @Transactional
    void deleteByUserIdAndId(String userId,long id);





}
