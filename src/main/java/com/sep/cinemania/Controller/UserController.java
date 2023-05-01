package com.sep.cinemania.Controller;

import com.sep.cinemania.Dao.UserRepository;
import com.sep.cinemania.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository user;

    @GetMapping("/")
    public List<User> getUserName() {
        user.save(new User(2,"test"));
        return (List<User>) user.findAll();
    }


}