package com.sep.cinemania.Service.User;
import com.sep.cinemania.Dao.User.UserRepository;
import com.sep.cinemania.Entities.User;
import com.sep.cinemania.Service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock(strictness = Mock.Strictness.LENIENT)
    private UserRepository userRepository;

    //succes
    @Test
    public void getUserList_should_returnTheUserList(){
        var user = new User("User1","tim","tim@gmail.com");
        when(userRepository.findOtherUsersById(user.getId())).thenReturn(List.of(new User("were232","bob","bob@gmail.com")
                ,new User("gfdg3434","joe","joe@gmail.com"),
                 new User("fsds221","tim","tim@gmail.com")));

        assertEquals(3,userService.findOtherUsersById(user.getId()).size());
    }

    //failed
    @Test
    public void getUserList_returnAnEmptyList() {
        var user = new User("1", "joe", "joe@gmail.com");
        when(userRepository.findOtherUsersById(user.getId())).thenReturn(null);
        List<User> userList = userService.findOtherUsersById(user.getId());
        assertNull(userList);
    }

    //succes
    @Test
    public void findUserByEmail_should_findTheUserByEmail(){
        var user = new User("fsds221","tim","tim@gmail.com");

        when(userRepository.findUserByEmail(user.getEmail())).thenReturn(user);

        assertEquals(user,userService.findUserByEmail(user.getEmail()));
    }

    //fail
    @Test
    public void fail_findUserByEmail(){
        var user = new User("fsds221","tim","tim@gmail.com");

        when(userRepository.findUserByEmail(user.getEmail())).thenReturn(null);

        assertNull(user.getEmail(),userService.findUserByEmail(user.getEmail()));
    }


    //succes
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
    public void findUserById() {
        var user = new User("were232", "tim", "tim@gmail.com");

        when(userService.findUserById(user.getId())).thenReturn(Optional.of(new User("were232", "bob", "bob@gmail.com")));

        Optional<User> actualUser = userService.findUserById(user.getId());
        assertTrue(actualUser.isPresent());

        String actualUserId = actualUser.get().getId();
        assertEquals(user.getId(), actualUserId);
    }


    @Test
    public void failFindingUserById() {
        var user = new User("were232", "tim", "tim@gmail.com");

        when(userService.findUserById(user.getId())).thenReturn(Optional.empty());

        Optional<User> actualUser = userService.findUserById(user.getId());
        assertFalse(actualUser.isPresent());
    }



}
