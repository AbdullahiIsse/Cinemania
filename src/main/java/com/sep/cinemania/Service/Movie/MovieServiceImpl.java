package com.sep.cinemania.Service.Movie;

import com.sep.cinemania.Dao.Movie.MovieRepository;
import com.sep.cinemania.Entities.Movie;
import com.sep.cinemania.Exception.Movie.MovieAlreadyExistException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MovieServiceImpl implements MovieService{
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public  List<Movie>findMoviesByUserId(String userId) {
        return movieRepository.findMoviesByUserId(userId);
    }

    @Override
    public Movie addMovie(Movie movie) {
      movieRepository.findById(movie.getId()).ifPresent(movie1 -> {
          if (movie.getId() == movie1.getId()){
              throw new MovieAlreadyExistException();
          }
      });
        return movieRepository.save(movie);
    }

    @Override
    public void deleteMovieById(long id) {
        movieRepository.deleteById(id);
    }
}
