package com.sep.cinemania.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class Movie {
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
    @Column(name = "user_id")
    @NotBlank(message = "userId is mandatory")
    private String userId;

}
