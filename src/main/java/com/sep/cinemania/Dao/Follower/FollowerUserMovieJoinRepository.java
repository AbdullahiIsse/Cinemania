package com.sep.cinemania.Dao.Follower;

import com.sep.cinemania.Entities.FollowerUserMovieJoin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FollowerUserMovieJoinRepository extends CrudRepository<FollowerUserMovieJoin,String> {
    @Query(nativeQuery = true,value = "select user_account.user_id,movie_id,displayname,email,title,release_date,vote_average,image from follower inner join user_account on follower.followed_id = user_account.user_id inner join movie on user_account.user_id = movie.user_id where follower.user_id = ?1")
    List<FollowerUserMovieJoin> getFollowerMovieList(String userId);
}
