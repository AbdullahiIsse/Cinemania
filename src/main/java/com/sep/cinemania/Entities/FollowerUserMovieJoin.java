package com.sep.cinemania.Entities;

import com.sep.cinemania.Entities.Ids.Follower.FollowerJoinIds;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(FollowerJoinIds.class)
public class FollowerUserMovieJoin {

    @Id
    @Column(name = "user_id")
    private String userId;
    @Id
    @Column(name = "movie_id")
    private long movieId;
    @Column(name = "displayname")
    private String displayName;
    @Column(name = "email")
    private String email;
    @Column(name = "title")
    private String title;
    @Column(name = "release_date")
    private String releaseDate;
    @Column(name = "vote_average")
    private double voteAverage;
    @Column(name = "image")
    @NotBlank(message = "image is mandatory")
    private String image;

    public FollowerUserMovieJoin(long movieId, String displayName, String email, String title, String releaseDate, double voteAverage, String image) {
        this.movieId = movieId;
        this.displayName = displayName;
        this.email = email;
        this.title = title;
        this.releaseDate = releaseDate;
        this.voteAverage = voteAverage;
        this.image = image;
    }
}
