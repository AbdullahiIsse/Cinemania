package com.sep.cinemania.Service.User;

import com.sep.cinemania.Dao.User.UserRepository;
import com.sep.cinemania.Entities.User;
import com.sep.cinemania.Exception.User.UserAlreadyExistException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


import org.mockito.junit.MockitoJUnitRunner;



import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock(strictness = Mock.Strictness.LENIENT)
    private UserRepository userRepository;


    @Test
    public void getUserList_should_returnTheUserList(){
        when(userRepository.findAll()).thenReturn(List.of(new User("were232","bob","bob@gmail.com")
                ,new User("gfdg3434","joe","joe@gmail.com"),
                 new User("fsds221","tim","tim@gmail.com")));

        assertEquals(3,userService.getUserList().size());
    }


    @Test
    public void findUserByEmail_should_findTheUserByEmail(){
        var email = "tim@gmail.com";
        var user = new User("fsds221","tim","tim@gmail.com");

        when(userRepository.findUserByEmail(email)).thenReturn(user);

        assertEquals(user,userService.findUserByEmail(email));
    }

    @Test
    public void createUser_should_succeed_when_UserDoNotAlreadyExist(){
        var user = new User("fsds2221","tim","tim1@gmail.com");
        when(userRepository.findUserByEmail(user.getEmail())).thenReturn(null);

        when(userRepository.save(user)).thenReturn(user);
        User user1 = userService.createUser(user);
        when(user1).thenReturn(user);

        assertEquals(user1.getId(),user.getId());
    }

    @Test
    public void createUser_should_fail_when_UserAlreadyExist(){
        var user = new User("fsds2221","tim","tim1@gmail.com");
        when(userRepository.findUserByEmail(user.getEmail())).thenReturn(user);

        assertThrows(UserAlreadyExistException.class, () -> userService.createUser(user));
    }



}
