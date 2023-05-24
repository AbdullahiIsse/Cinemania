package com.sep.cinemania.Dao.Follower;

import com.sep.cinemania.Entities.FollowerUserMovieJoin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FollowerUserMovieJoinRepository extends CrudRepository<FollowerUserMovieJoin,String> {
    @Query(nativeQuery = true,value = "SELECT follower.user_id AS follower_user_id, follower.followed_id, user_account.displayname, user_account.email, movie.movie_id, movie.title,movie.release_date, movie.vote_average FROM follower INNER JOIN user_account ON follower.followed_id = user_account.user_id INNER JOIN movie ON user_account.user_id = movie.user_id WHERE follower.user_id = ?1")
    List<FollowerUserMovieJoin> getFollowerMovieList(String userId);
}
