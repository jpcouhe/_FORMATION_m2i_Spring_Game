package com.m2iformation._formation_spring_game.controller.models;

public class SignupRequest {

    private String username;
    private String password;


    public SignupRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
