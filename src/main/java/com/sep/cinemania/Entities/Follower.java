package com.sep.cinemania.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "follower")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(FollowerIds.class)
public class Follower {
    @Id
    @Column(name = "user_id")
    @NotBlank(message = "user id is mandatory")
    private String userId;
    @Id
    @Column(name = "followed_id")
    @NotBlank(message = "followed is mandatory")
    private String followedId;
}
