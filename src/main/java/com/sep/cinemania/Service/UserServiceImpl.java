package com.sep.cinemania.Service;

import com.sep.cinemania.Dao.UserRepository;
import com.sep.cinemania.Entities.User;
import com.sep.cinemania.Exception.User.UserAlreadyExistException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository user;

    public UserServiceImpl(UserRepository user) {
        this.user = user;
    }

    @Override
    public List<User> getUserList() {
        return user.findAll();
    }

    @Override
    public User findUserByEmail(String email) {
        return this.user.findUserByEmail(email);
    }

    @Override
    public User createUser(User user) {
        var userInDb = findUserByEmail(user.getEmail());
        Optional.ofNullable(userInDb).ifPresent(user1 -> {
            if (user1.getEmail().equals(user.getEmail()) || user1.getId().equals(user.getId())) {
                throw new UserAlreadyExistException();
            }
        });
        return this.user.save(user);
    }


}
