package com.sep.cinemania.Service.User;

import com.sep.cinemania.Dao.User.UserRepository;
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
        return user.findUserByEmail(email);
    }

    @Override
    public User createUser(User createdUser) {
        var userInDb = findUserByEmail(createdUser.getEmail());
        Optional.ofNullable(userInDb).ifPresent(user1 -> {
            if (user1.getEmail().equals(createdUser.getEmail()) || user1.getId().equals(createdUser.getId())) {
                throw new UserAlreadyExistException();
            }
        });
        return user.save(createdUser);
    }

    @Override
    public Optional<User> findUserById(String id) {
        return user.findById(id);
    }

}
