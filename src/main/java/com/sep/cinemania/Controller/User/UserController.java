package com.sep.cinemania.Controller.User;

import com.sep.cinemania.Entities.User;
import com.sep.cinemania.Exception.User.UserAlreadyExistException;
import com.sep.cinemania.Service.User.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user")
@Tag(name = "User API")
@CrossOrigin(origins = "http://localhost")
public class UserController {
    private final UserService user;

    @Autowired
    public UserController(UserService user) {
        this.user = user;
    }

    @GetMapping
    @Operation(summary = "Get all the users")
    @ApiResponse(responseCode = "200",
            description = "OK",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))
    )
    public ResponseEntity<List<User>> getUserName() {
        List<User> users = user.getUserList();
        return ResponseEntity.ok(users);
    }


    @PostMapping
    @Operation(summary = "Create a User")
    @ApiResponse(responseCode = "201",
            description = "Created",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))
    )

    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        try {
            var createdUser = this.user.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.notFound().header("Message","User already exists").build();
        }
    }

}