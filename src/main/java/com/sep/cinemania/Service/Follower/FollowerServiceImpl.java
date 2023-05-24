package com.sep.cinemania.Service.Follower;

import com.sep.cinemania.Dao.Follower.FollowerRepository;
import com.sep.cinemania.Dao.Follower.FollowerUserMovieJoinRepository;
import com.sep.cinemania.Entities.Follower;
import com.sep.cinemania.Entities.FollowerUserMovieJoin;
import com.sep.cinemania.Exception.Follower.FollowedUserAlreadyExist;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FollowerServiceImpl implements FollowerService{

    private final FollowerUserMovieJoinRepository followerUserMovieJoinRepository;
    private final FollowerRepository followerRepository;

    public FollowerServiceImpl(FollowerUserMovieJoinRepository followerUserMovieJoinRepository, FollowerRepository followerRepository) {
        this.followerUserMovieJoinRepository = followerUserMovieJoinRepository;
        this.followerRepository = followerRepository;
    }

    @Override
    public List<FollowerUserMovieJoin> getFollowerMovieList(String userId) {
        return followerUserMovieJoinRepository.getFollowerMovieList(userId);
    }

    @Override
    public Follower follow(Follower follower) {
        var followerInDb = followerRepository.findFollowerByUserIdAndFollowedId(follower.getUserId(), follower.getFollowedId());
        Optional.ofNullable(followerInDb).ifPresent(follower1 -> {
            if (follower1.getUserId().equals(follower.getUserId()) && follower1.getFollowedId().equals(follower.getFollowedId())){
                throw new FollowedUserAlreadyExist();
            }
        });
        return followerRepository.save(follower);
    }

    @Override
    public void deleteFollowerByIds(String userId, String followedId) {
        followerRepository.deleteByUserIdAndFollowedId(userId, followedId);
    }


}
