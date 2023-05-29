package com.sep.cinemania.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Review")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @Column(name = "review_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_generator")
    @SequenceGenerator(name = "review_generator", sequenceName = "review_seq", allocationSize = 1)
    private long id;

    @Column(name = "rating")
    private float rating;

    @Column(name = "text")
    private String text;

    @Column(name = "timestamp")
    private String timestamp;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "movie_id")
    private long movieId;
}
