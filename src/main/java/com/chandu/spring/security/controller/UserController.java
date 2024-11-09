package com.chandu.spring.security.controller;

import com.chandu.spring.security.dto.UserResponse;
import com.chandu.spring.security.model.User;
import com.chandu.spring.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{
    @Autowired
    private UserService service;

    @PostMapping("/register")
    public UserResponse register(@RequestBody User user)
    {
        return service.saveUser(user);
    }
}
