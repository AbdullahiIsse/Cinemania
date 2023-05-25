package com.sep.cinemania.Service.Movie;

import com.sep.cinemania.Entities.Movie;
import com.sep.cinemania.Exception.Movie.MovieAlreadyExistException;

import java.util.List;

public interface MovieService {
    List<Movie>findMoviesByUserId(String userId);
    Movie addMovie(Movie movie) throws MovieAlreadyExistException;
    void deleteMovieById(long movieId,String userId);
}
