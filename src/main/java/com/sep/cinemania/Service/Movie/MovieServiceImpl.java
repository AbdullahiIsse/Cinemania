package com.sep.cinemania.Service.Movie;

import com.sep.cinemania.Dao.Movie.MovieRepository;
import com.sep.cinemania.Entities.Movie;
import com.sep.cinemania.Entities.Ids.Movie.MovieIds;
import com.sep.cinemania.Exception.Movie.MovieAlreadyExistException;
import com.sep.cinemania.Exception.User.UserDoNotExistException;
import com.sep.cinemania.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    private UserService userService;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findMoviesByUserId(String userId) {
        return movieRepository.findMoviesByUserId(userId);
    }

    @Override
    public Movie addMovie(Movie movie) {
        if (userService.findUserById(movie.getUserId()).isEmpty()) {
            throw new UserDoNotExistException();
        }
        movieRepository.findById(new MovieIds(movie.getUserId(),movie.getId())).ifPresent(movie1 -> {
            if (movie.getId()  == movie1.getId() && movie.getUserId().equals(movie1.getUserId())) {
                throw new MovieAlreadyExistException();
            }
        });
        return movieRepository.save(movie);
    }

    @Override
    public void deleteMovieById(long movieId,String userId) {
        movieRepository.deleteById(new MovieIds(userId,movieId));
    }
}
