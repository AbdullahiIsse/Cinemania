package com.sep.cinemania.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(FollowerIds.class)
public class FollowerUserMovieJoin {

    @Id
    @Column(name = "follower_user_id")
    private String userId;
    @Id
    @Column(name = "followed_id")
    private String followedId;
    @Column(name = "displayname")
    private String displayName;
    @Column(name = "email")
    private String email;
    @Column(name = "movie_id")
    private long movieId;
    @Column(name = "title")
    private String title;
    @Column(name = "release_date")
    private String releaseDate;
    @Column(name = "vote_average")
    private double voteAverage;

}
