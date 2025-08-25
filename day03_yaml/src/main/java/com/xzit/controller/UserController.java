package com.xzit.controller;

import com.xzit.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private Users users;

    @Autowired
    public UserController(Users users) {
        this.users = users;
    }
    @GetMapping("/user")
    public Object getUsers() {
        return users;
    }
}
