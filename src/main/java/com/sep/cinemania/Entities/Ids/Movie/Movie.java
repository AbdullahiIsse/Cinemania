package com.sep.cinemania.Entities.Ids.Movie;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "movie")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(MovieIds.class)
public class Movie {
    @Id
    @Column(name = "user_id")
    @NotBlank(message = "userId is mandatory")
    private String userId;
    @Id
    @Column(name = "movie_id")
    @NotNull(message = "id is mandatory")
    private long id;
    @Column(name = "title")
    @NotBlank(message = "title is mandatory")
    private String title;
    @Column(name = "release_date")
    @NotBlank(message = "releaseDate is mandatory")
    private String releaseDate;
    @Column(name = "vote_average")
    @NotNull(message = "voteAverage is mandatory")
    private double voteAverage;
    @Column(name = "image")
    @NotBlank(message = "image is mandatory")
    private String image;


    public Movie(long id, String title, String releaseDate, double voteAverage, String image) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.voteAverage = voteAverage;
        this.image = image;
    }
}
