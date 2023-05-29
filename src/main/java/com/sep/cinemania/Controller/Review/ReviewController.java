package com.sep.cinemania.Controller.Review;

import com.sep.cinemania.Entities.Review;
import com.sep.cinemania.Entities.ReviewJoinUser;
import com.sep.cinemania.Service.Review.ReviewService;
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
@RequestMapping("/api/review")
@Tag(name = "Review API")
@CrossOrigin(origins = {"http://localhost", "https://cinemania2.azurewebsites.net"})
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @GetMapping("/movie/{movieId}")
    @Operation(summary = "Get Review by movie")
    @ApiResponse(responseCode = "200",
            description = "OK",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ReviewJoinUser.class))
    )
    public ResponseEntity<List<ReviewJoinUser>> getReviewByMovie(@PathVariable("movieId") long movieId) {
        var review = reviewService.getReviewByMovieId(movieId);
        return ResponseEntity.ok(review);
    }

    @PostMapping
    @Operation(summary = "Review a movie")
    @ApiResponse(responseCode = "201",
            description = "Created",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Review.class))
    )
    public ResponseEntity<Review> reviewAMovie(@Valid @RequestBody Review review) {
        try {
            var newReview = reviewService.addReview(review);
            return ResponseEntity.status(HttpStatus.CREATED).body(newReview);
        } catch (Exception e) {
            return ResponseEntity.notFound().header("Message", "something went wrong").build();
        }
    }


    @PatchMapping("/{id}/{userId}")
    @Operation(summary = " Update Review by id and UserId")
    @ApiResponse(responseCode = "200",
            description = "OK",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Review.class))
    )
    public Review updateCommentByIdAndUserId(@RequestBody @Valid Review review,@PathVariable("id") long id,@PathVariable("userId") String userId){

        Review review1 = reviewService.getReviewByUserIdAndId(userId, id);

        if (review.getRating() != 0){

            review1.setRating(review.getRating());
        }

        if (review.getText() != null){

            review1.setText(review.getText());
        }

        if (review.getTimestamp() != null){

            review1.setTimestamp(review.getTimestamp());
        }
        return reviewService.addReview(review1);
    }

    @GetMapping("/movie/avg/{movieId}")
    @Operation(summary = "Get Average Rating By MovieId")
    @ApiResponse(responseCode = "200",
            description = "OK",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Review.class))
    )
    public ResponseEntity<Float> getAverageRatingByMovieId(@PathVariable("movieId") long movieId) {
        var averageRating = reviewService.getAverageRatingByMovieId(movieId);
        return ResponseEntity.ok(averageRating);
    }

    @GetMapping("/movie/count/{movieId}")
    @Operation(summary = "Count all by movieId")
    @ApiResponse(responseCode = "200",
            description = "OK",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Review.class))
    )
    public ResponseEntity<Long> countAllByMovieId(@PathVariable("movieId") long movieId) {
        var countValue = reviewService.countAllByMovieId(movieId);
        return ResponseEntity.ok(countValue);
    }

    @DeleteMapping("/{id}/{userId}")
    @Operation(summary = " Review by id and userId")
    @ApiResponse(responseCode = "200",
            description = "OK",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Review.class))
    )
    public void removeReviewByIdAndUserId(@PathVariable("id") long id,@PathVariable("userId") String userId) {
        try {
            reviewService.deleteByUserIdAndId(userId, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

}
