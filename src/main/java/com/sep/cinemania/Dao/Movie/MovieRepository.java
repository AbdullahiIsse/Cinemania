package com.sep.cinemania.Dao.Movie;

import com.sep.cinemania.Entities.Ids.Movie.Movie;
import com.sep.cinemania.Entities.Ids.Movie.MovieIds;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends  CrudRepository<Movie, MovieIds> {

    List<Movie>findMoviesByUserId(@NotBlank(message = "userId is mandatory") String userId);

}
