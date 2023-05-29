package com.sep.cinemania.Service.Movie;

import com.sep.cinemania.Dao.Movie.MovieRepository;
import com.sep.cinemania.Entities.Ids.Movie.Movie;
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
public class MovieServiceTest {

    @InjectMocks
    private MovieServiceImpl movieService;

    @Mock(strictness = Mock.Strictness.LENIENT)
    private MovieRepository movieRepository;

    //success
   @Test
    public void findMoviesByUserId(){
       var user = new User("User1","tim","tim@gmail.com");
        when(movieRepository.findMoviesByUserId(user.getId())).thenReturn(List.of(new Movie(234,"avatar","2023-01-27",8.7, "/pnQYjZ.jpg")
                ,new Movie(840332,"home","2023-01-28",8.7, "/pnQsdfjZ.jpg"),
                new Movie(840777,"tesla","2023-01-29",8.7, "/pnQYsdfZ.jpg")));

        assertEquals(3,movieService.findMoviesByUserId(user.getId()).size());
    }


    @Test
    public void failfindMoviesByUserId() {
        var user = new User("1", "joe", "joe@gmail.com");
        when(movieRepository.findMoviesByUserId(user.getId())).thenReturn(null);
        List<Movie> movieList = movieService.findMoviesByUserId(user.getId());
        assertNull(movieList);
    }





}
