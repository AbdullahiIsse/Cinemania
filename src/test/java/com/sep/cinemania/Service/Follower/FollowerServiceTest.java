package com.sep.cinemania.Service.Follower;

import com.sep.cinemania.Dao.Follower.FollowerRepository;
import com.sep.cinemania.Dao.Follower.FollowerUserMovieJoinRepository;
import com.sep.cinemania.Entities.Follower;
import com.sep.cinemania.Entities.FollowerUserMovieJoin;
import com.sep.cinemania.Entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FollowerServiceTest {

    @InjectMocks
    private FollowerServiceImpl followerService;

    @Mock(strictness = Mock.Strictness.LENIENT)
    private FollowerRepository followerRepository;

    @Mock(strictness = Mock.Strictness.LENIENT)
    private FollowerUserMovieJoinRepository followerUserMovieJoinRepository;


    //succed
    @Test
    public void testGetFollowerMovieListByUserId() {

        var follower = new Follower("User1", "follower2");

        when(followerUserMovieJoinRepository.getFollowerMovieList(follower.getUserId())).thenReturn(List.of(
                new FollowerUserMovieJoin(12, "Leo", "Leo@gmail.com", "avatar", "2023-01-29", 8.7, "/pnQYjZ.jpg"),
                new FollowerUserMovieJoin(13, "ben", "ben@gmail.com", "mario", "2023-01-04", 8.5, "/pdQYjZ.jpg"),
                new FollowerUserMovieJoin(14, "Alex", "Alex@gmail.com", "tesla", "2023-01-03", 8.4, "/piQYjZ.jpg")
        ));

        assertEquals(3, followerService.getFollowerMovieList(follower.getUserId()).size());
    }


    //fails
    @Test
    public void testGetFollowerMovieListByUserIdWhenFailed() {

        var follower = new Follower("User1", "follower2");

        when(followerUserMovieJoinRepository.getFollowerMovieList(follower.getUserId())).thenReturn(null);

        assertNull(follower.getUserId(),followerService.getFollowerMovieList(follower.getUserId()));

    }

    //success
    @Test
    public void findFollowersByUserId() {

        var user = new User("fsds221","tim","tim@gmail.com");

        when(followerRepository.findFollowersByUserId(user.getId())).thenReturn(List.of(
                new Follower("1", "Leo"),
                new Follower("1", "Leo"),
                new Follower("1", "Leo")
        ));

        assertEquals(3, followerService.findFollowersByUserId(user.getId()).size());
    }

    //fails
    @Test
    public void failWhenfindFollowersByUserId() {

        var user = new User("fsds221","tim","tim@gmail.com");

        when(followerRepository.findFollowersByUserId(user.getId())).thenReturn(null);

        assertNull(user.getId(),followerService.findFollowersByUserId(user.getId()));
    }

}
