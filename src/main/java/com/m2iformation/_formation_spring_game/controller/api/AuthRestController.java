package com.m2iformation._formation_spring_game.controller.api;

import com.m2iformation._formation_spring_game.controller.exception.UserAlreadyExistException;
import com.m2iformation._formation_spring_game.controller.models.SigninRequest;
import com.m2iformation._formation_spring_game.controller.models.SignupRequest;
import com.m2iformation._formation_spring_game.entity.User;
import com.m2iformation._formation_spring_game.security.jwt.JwtResponse;
import com.m2iformation._formation_spring_game.security.jwt.JwtUtils;
import com.m2iformation._formation_spring_game.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
public class AuthRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private JwtUtils jwtUtils;
    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody SignupRequest dto){

        try{

        userService.signup(dto);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch(UserAlreadyExistException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody SigninRequest dto){


        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());

        // Check Authentification for username passed in SigninRequest
        Authentication authentication = authenticationManager.authenticate(auth);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Generate JSON Web Token (JWT)

        String generatedToken = jwtUtils.generateJwtToken(authentication);

        // TODO : return usernam from Authentication SecurityContextHolder
        User connectedUser = (User) authentication.getPrincipal();
        JwtResponse jwtResponse = new JwtResponse(connectedUser.getUsername(), generatedToken);


        return ResponseEntity.status(HttpStatus.OK).body(jwtResponse);
    }



}
