package com.sep.cinemania.Dao.Follower;

import com.sep.cinemania.Entities.Follower;
import com.sep.cinemania.Entities.Ids.Follower.FollowerIds;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FollowerRepository extends CrudRepository<Follower, FollowerIds> {
    Follower findFollowerByUserIdAndFollowedId(String userId,String followedId );
    @Transactional
    void deleteByUserIdAndFollowedId(String userId,String followedId );
    @Query(nativeQuery = true,value = "select * from follower where user_id = ?1")
    List<Follower> findFollowersByUserId(String userId);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM follower WHERE user_id = ?1 AND followed_id IN (SELECT user_id FROM user_Account WHERE email = ?2)")
    void deleteByUserIdAndEmail(String userId, String email);
}
