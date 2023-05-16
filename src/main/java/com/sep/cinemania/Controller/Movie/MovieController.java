package com.sep.cinemania.Controller.Movie;

import com.sep.cinemania.Entities.Movie;
import com.sep.cinemania.Exception.Movie.MovieAlreadyExistException;
import com.sep.cinemania.Exception.User.UserDoNotExistException;
import com.sep.cinemania.Service.Movie.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
@Tag(name = "Movie API")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Movies by UserId")
    @ApiResponse(responseCode = "200",
            description = "OK",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))
    )
    public ResponseEntity<List<Movie>> getMovieByUserId(@PathVariable("id") String id) {
        var movieByUser = movieService.findMoviesByUserId(id);
        return ResponseEntity.ok(movieByUser);
    }

    @PostMapping
    @Operation(summary = "Add a Movie")
    @ApiResponse(responseCode = "201",
            description = "Created",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))
    )

    public ResponseEntity<Movie> addMovie(@Valid @RequestBody Movie movie) {
        try {
            var createdMovie = movieService.addMovie(movie);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdMovie);
        } catch (MovieAlreadyExistException | UserDoNotExistException e) {
            return ResponseEntity.notFound().header("Message", "Movie already exists or user doesn't exist").build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Movie by Id")
    @ApiResponse(responseCode = "200",
            description = "OK",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))
    )
    public void removeMoviesById(@PathVariable("id") long id) {
        try {
            movieService.deleteMovieById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }


}
