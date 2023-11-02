package com.domain.controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.sql.Date;

import javax.crypto.SecretKey;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.domain.model.ApiResponse;
import com.domain.model.LoginRequest;
import com.domain.model.TokenResponse;

@RestController
public class LoginController {

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody LoginRequest request) {
        // Validasi email
        if (!isValidEmail(request.getEmail())) {
            return ResponseEntity.badRequest().body(new ApiResponse(102, "Parameter email tidak sesuai format", null));
        }

        // Validasi panjang password
        if (request.getPassword().length() < 8) {
            return ResponseEntity.badRequest().body(new ApiResponse(103, "Panjang password kurang dari 8 karakter", null));
        }

        // Simulasikan autentikasi (Anda dapat menggantinya dengan logika autentikasi yang sesuai dengan aplikasi Anda)
        boolean authenticationSuccess = authenticateUser(request.getEmail(), request.getPassword());

        if (authenticationSuccess) {
            // Generate JWT token
            String token = generateJwtToken(request.getEmail());

            return ResponseEntity.ok(new ApiResponse(0, "Login Sukses", new TokenResponse(token)));
        } else {
            return ResponseEntity.status(401).body(new ApiResponse(103, "Username atau password salah", null));
        }
    }

    private boolean isValidEmail(String email) {
        // Validasi format email
        // Misalnya: return email.matches("pattern_reguler_email")
        return true;
    }

    private boolean authenticateUser(String email, String password) {
        // Simulasi autentikasi pengguna
        // Anda dapat menggantinya dengan logika autentikasi yang sesuai dengan aplikasi Anda
        return true;
    }

    private String generateJwtToken(String email) {
    // Generate JWT token dengan payload email dan expiration selama 12 jam
    byte[] keyBytes = "yourSecretKey".getBytes(); // Ganti dengan kunci rahasia yang sesuai
    SecretKey key = Keys.hmacShaKeyFor(keyBytes);

    String token = Jwts.builder()
            .setSubject(email)
            .setExpiration(new Date(System.currentTimeMillis() + 12 * 60 * 60 * 1000))
            .signWith(key)
            .compact();
    return token;
    }
}

