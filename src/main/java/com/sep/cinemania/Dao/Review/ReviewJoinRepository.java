package com.sep.cinemania.Dao.Review;

import com.sep.cinemania.Entities.Review;
import com.sep.cinemania.Entities.ReviewJoinUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewJoinRepository extends CrudRepository<ReviewJoinUser,Long> {

    @Query(nativeQuery = true,value = "select review_id,rating,text,timestamp,Review.user_id,displayname from Review inner join user_account on Review.user_id = user_account.user_id where movie_id = ?1")
    List<ReviewJoinUser> getReviewByMovieId(long movieId);
}
