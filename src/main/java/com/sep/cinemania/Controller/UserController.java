package com.sep.cinemania.Controller;

import com.sep.cinemania.Dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    private UserRepository user;

    @GetMapping("/")
    public String getUserName() {
        return "test";
    }


}