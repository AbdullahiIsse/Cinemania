package com.sep.cinemania.Dao.Follower;

import com.sep.cinemania.Entities.FollowerUserJoin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FollowerUserRepository extends CrudRepository<FollowerUserJoin,String> {
    @Query(nativeQuery = true,value = "select email,displayname from follower inner join user_Account on follower.followed_id = user_account.user_id where follower.user_id = ?1")
    List<FollowerUserJoin> getFollowedUsers(String userId);
}
