package com.sep.cinemania.Service.User;

import com.sep.cinemania.Entities.User;
import com.sep.cinemania.Exception.User.UserAlreadyExistException;

import java.util.List;

public interface UserService {
    List<User> getUserList();
    User createUser(User user) throws UserAlreadyExistException;

    User findUserByEmail(String email);
}
