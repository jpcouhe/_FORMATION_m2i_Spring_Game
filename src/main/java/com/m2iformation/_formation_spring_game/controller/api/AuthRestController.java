package com.m2iformation._formation_spring_game.controller.api;

import com.m2iformation._formation_spring_game.controller.models.SigninRequest;
import com.m2iformation._formation_spring_game.controller.models.SignupRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthRestController {

    @PostMapping("/signup")
    public ResponseEntity<?> signup(SignupRequest dto){


        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(SigninRequest dto){
        return ResponseEntity.status(HttpStatus.OK).build();
    }



}
