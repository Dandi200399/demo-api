package com.domain.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.domain.model.ApiResponse;
import com.domain.model.entities.UserProfile;

@RestController
public class ProfileController {

    @GetMapping("/profile")
    public ResponseEntity<ApiResponse> getProfile(@RequestHeader("Authorization") String authorizationHeader) {
        // Validasi Token
        String token = extractTokenFromHeader(authorizationHeader);
        if (token == null) {
            return ResponseEntity.status(401).body(new ApiResponse(108, "Token tidak valid atau kadaluwarsa", null));
        }

        // Dekode Token dan dapatkan email dari payload
        String email = decodeTokenAndGetEmail(token);

        // Simulasikan pengambilan informasi profil pengguna
        UserProfile userProfile = getProfileInfo(email);

        if (userProfile != null) {
            return ResponseEntity.ok(new ApiResponse(0, "Sukses", userProfile));
        } else {
            return ResponseEntity.status(401).body(new ApiResponse(108, "Token tidak valid atau kadaluwarsa", null));
        }
    }

    private String extractTokenFromHeader(String authorizationHeader) {
        // Mengambil token dari header Authorization (Bearer Token)
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring(7);
        }
        return null;
    }

    private String decodeTokenAndGetEmail(String token) {
        // Mendekode token JWT dan mengambil email dari payload
        // Anda harus menggunakan kunci rahasia yang sesuai untuk verifikasi token
        // Misalnya: return getEmailFromToken(token, "yourSecretKey")
        return "user@nutech-integrasi.com";
    }

    private UserProfile getProfileInfo(String email) {
        // Simulasikan pengambilan informasi profil pengguna
        // Anda dapat menggantinya dengan logika pengambilan profil yang sesuai dengan aplikasi Anda
        return new UserProfile(email, "User", "Nutech", "https://yoururlapi.com/profile.jpeg");
    }
}

