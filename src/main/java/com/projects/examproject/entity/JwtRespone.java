package com.projects.examproject.entity;

public class JwtRespone {
    String token;

    public JwtRespone() {
    }

    public JwtRespone(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
