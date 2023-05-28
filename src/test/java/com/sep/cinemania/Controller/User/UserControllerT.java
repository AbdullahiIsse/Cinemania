package com.sep.cinemania.Controller.User;

import com.sep.cinemania.Dao.User.UserRepository;
import com.sep.cinemania.Entities.Movie;
import com.sep.cinemania.Entities.User;
import com.sep.cinemania.Service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class UserControllerT {

    @InjectMocks
    private UserService userService;

    @Mock(strictness = Mock.Strictness.LENIENT)
    private UserController userController;

    @Test
    void testGetOtherUsersById() {

        UserService userService = Mockito.mock(UserService.class);
        UserController userController = new UserController(userService);

        var user = new User("User1","tim","tim@gmail.com");

        List<User> expectedUsers = Arrays.asList(
                new User("User1", "tim", "tim@gmail.com"),
                new User("User2", "tom", "tom@gmail.com")
        );

        when(userService.findOtherUsersById(user.getId())).thenReturn(expectedUsers);

        ResponseEntity<List<User>> response = userController.getOtherUsersById(user.getId());

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(expectedUsers, response.getBody());
    }




}
