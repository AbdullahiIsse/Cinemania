package com.sep.cinemania.Controller.Follower;

import com.sep.cinemania.Entities.Follower;
import com.sep.cinemania.Entities.Ids.Follower.FollowerUserJoin;
import com.sep.cinemania.Entities.FollowerUserMovieJoin;
import com.sep.cinemania.Exception.Follower.FollowedUserAlreadyExist;
import com.sep.cinemania.Service.Follower.FollowerService;
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
@RequestMapping("/api/follower")
@Tag(name = "Follower API")
@CrossOrigin(origins = {"http://localhost", "https://cinemania2.azurewebsites.net"})
public class FollowerController {

    private final FollowerService followerService;


    public FollowerController(FollowerService followerService) {
        this.followerService = followerService;
    }


    @GetMapping("/{id}")
    @Operation(summary = "Get Follower Movie List")
    @ApiResponse(responseCode = "200",
            description = "OK",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = FollowerUserMovieJoin.class))
    )
    public ResponseEntity<List<FollowerUserMovieJoin>> getFollowerMovieList(@PathVariable("id") String id) {
        var follower = followerService.getFollowerMovieList(id);
        return ResponseEntity.ok(follower);
    }


    @PostMapping
    @Operation(summary = "Follow a User")
    @ApiResponse(responseCode = "201",
            description = "Created",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Follower.class))
    )
    public ResponseEntity<Follower> followUser(@Valid @RequestBody Follower follower) {
        try {
            var userFollowed = followerService.follow(follower);
            return ResponseEntity.status(HttpStatus.CREATED).body(userFollowed);
        } catch (FollowedUserAlreadyExist e) {
            return ResponseEntity.notFound().header("Message", "You are already following that user").build();
        }
    }

    @DeleteMapping("/{userId}/{followedId}")
    @Operation(summary = " unFollow user by Ids")
    @ApiResponse(responseCode = "200",
            description = "OK",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Follower.class))
    )
    public void removeFollowerByIds(@PathVariable("userId") String userId, @PathVariable("followedId") String followedId) {
        try {
            followerService.deleteFollowerByIds(userId, followedId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = " Find followers by userId")
    @ApiResponse(responseCode = "200",
            description = "OK",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Follower.class))
    )
    public ResponseEntity<List<Follower>> findFollowerById(@PathVariable("userId") String userId) {
            var followers = followerService.findFollowersByUserId(userId);
            return ResponseEntity.ok(followers);
    }

    @GetMapping("/followed/{userId}")
    @Operation(summary = "Get Followed User List")
    @ApiResponse(responseCode = "200",
            description = "OK",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = FollowerUserJoin.class))
    )
    public ResponseEntity<List<FollowerUserJoin>> getFollowedUser(@PathVariable("userId") String userId) {
        var followedUsers = followerService.getFollowedUsers(userId);
        return ResponseEntity.ok(followedUsers);
    }


    @DeleteMapping("/email/{userId}/{email}")
    @Operation(summary = " unFollow user by userid and email")
    @ApiResponse(responseCode = "200",
            description = "OK",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Follower.class))
    )
    public void removeFollowerByUserIdAndEmail(@PathVariable("userId") String userId, @PathVariable("email") String email) {
        try {
         followerService.deleteByUserIdAndEmail(userId, email);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }


}
