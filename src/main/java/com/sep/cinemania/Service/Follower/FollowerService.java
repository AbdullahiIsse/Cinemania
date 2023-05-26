package com.sep.cinemania.Service.Follower;

import com.sep.cinemania.Entities.Follower;
import com.sep.cinemania.Entities.FollowerUserJoin;
import com.sep.cinemania.Entities.FollowerUserMovieJoin;


import java.util.List;

public interface FollowerService {
    List<FollowerUserMovieJoin> getFollowerMovieList(String userId);
    Follower follow(Follower follower) ;

    void deleteFollowerByIds(String userId,String followedId);

    List<Follower> findFollowersByUserId(String userId );
    List<FollowerUserJoin> getFollowedUsers(String userId);
}
