package com.sep.cinemania.Service.Movie;

import com.sep.cinemania.Dao.Movie.MovieRepository;
import com.sep.cinemania.Entities.Movie;
import com.sep.cinemania.Entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTest {

    @InjectMocks
    private MovieServiceImpl movieService;

    @Mock(strictness = Mock.Strictness.LENIENT)
    private MovieRepository movieRepository;

/*    @Test
    public void findMoviesByUserId(){
        var movie = new Movie(840326,"avatar","2023-01-27",8.7, "/pnQYjDxqZ3C6reI8N0MfNi4NMkZ.jpg");
        when(movieRepository.findMoviesByUserId(movie.getUserId()).thenReturn(List.of(new User("were232","bob","bob@gmail.com")
                ,new User("gfdg3434","joe","joe@gmail.com"),
                new User("fsds221","tim","tim@gmail.com")));

        assertEquals(3,userService.findOtherUsersById(user.getId()).size());
    }*/

}
