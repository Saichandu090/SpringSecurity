package com.chandu.spring.security.service;

import com.chandu.spring.security.dto.UserResponse;
import com.chandu.spring.security.model.User;
import com.chandu.spring.security.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    public UserRepo userRepo;

    private final BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
    public UserResponse saveUser(User user)
    {
        user.setPassword(encoder.encode(user.getPassword()));
        return userResponseToDTO(userRepo.save(user));
    }

    private UserResponse userResponseToDTO(User user)
    {
        UserResponse userResponse=new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setUsername(user.getUsername());
        return userResponse;
    }
}
