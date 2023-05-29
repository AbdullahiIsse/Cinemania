package com.sep.cinemania.Entities.Ids.Follower;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FollowerIds implements Serializable {
    private String userId;
    private String followedId;
}
