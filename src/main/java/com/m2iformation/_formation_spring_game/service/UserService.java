package com.m2iformation._formation_spring_game.service;

import com.m2iformation._formation_spring_game.controller.exception.UserAlreadyExistException;
import com.m2iformation._formation_spring_game.controller.models.SignupRequest;
import com.m2iformation._formation_spring_game.entity.User;

import com.m2iformation._formation_spring_game.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;
    public  void signup(SignupRequest dto) throws UserAlreadyExistException  {

        boolean alreadyExist = userRepository.existsByUsername(dto.getUsername());
        if (alreadyExist) {
            throw new UserAlreadyExistException(dto.getUsername());
        } else {
            User newUser = new User(dto.getUsername(), encoder.encode(dto.getPassword()));
            userRepository.save(newUser);
        }
    }
}
