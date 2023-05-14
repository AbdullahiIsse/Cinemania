package com.sep.cinemania.Controller;

import com.sep.cinemania.Dao.UserRepository;
import com.sep.cinemania.Entities.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "User API")
public class UserController {
    private final UserRepository user;

    @Autowired
    public UserController(UserRepository user) {
        this.user = user;
    }

    @GetMapping("/user")
    @Operation(summary = "Get all the users")
    @ApiResponse(responseCode = "200",
            description = "OK",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))
    )
    public ResponseEntity<List<User>> getUserName() {
        List<User> users = (List<User>) user.findAll();
        return users.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(users);
    }


}