package com.domain.model;

public class TokenResponse {
    private String token;

    public TokenResponse(String token) {
        this.token = token;
    }

    // Buat getter dan setter untuk properti 'token'
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

