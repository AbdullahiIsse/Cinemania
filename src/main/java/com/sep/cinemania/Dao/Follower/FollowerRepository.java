package com.sep.cinemania.Dao.Follower;

import com.sep.cinemania.Entities.Follower;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

public interface FollowerRepository extends CrudRepository<Follower,String> {
    Follower findFollowerByUserIdAndFollowedId(String userId,String followedId );
    @Transactional
    void deleteByUserIdAndFollowedId(String userId,String followedId );
}
