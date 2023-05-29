package com.sep.cinemania.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewJoinUser {

    @Id
    @Column(name = "review_id")
    private long reviewId;

    @Column(name = "rating")
    private float rating;

    @Column(name = "text")
    private String text;

    @Column(name = "timestamp")
    private String timestamp;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "displayname")
    private String displayName;

}
