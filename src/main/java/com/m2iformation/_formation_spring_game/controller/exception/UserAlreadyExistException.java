package com.m2iformation._formation_spring_game.controller.exception;

public class UserAlreadyExistException extends Exception {


    public UserAlreadyExistException(String username) {
        super(username + " already exist in database");
    }
}
