package com.domain.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.domain.model.ApiResponse;
import com.domain.model.entities.UserProfile;

@RestController
public class UpdateProfileController {

    @PutMapping("/profile/update")
    public ResponseEntity<ApiResponse> updateProfile(@RequestHeader("Authorization") String authorizationHeader, @RequestBody UserProfile userProfileUpdate) {
        // Validasi Token
        String token = extractTokenFromHeader(authorizationHeader);
        if (token == null) {
            return ResponseEntity.status(401).body(new ApiResponse(108, "Token tidak valid atau kadaluwarsa", null));
        }

        // Dekode Token dan dapatkan email dari payload
        String email = decodeTokenAndGetEmail(token);

        // Simulasikan pembaruan profil pengguna
        UserProfile updatedProfile = updateProfileInfo(email, userProfileUpdate);

        if (updatedProfile != null) {
            return ResponseEntity.ok(new ApiResponse(0, "Update Profile berhasil", updatedProfile));
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

    private UserProfile updateProfileInfo(String email, UserProfile userProfileUpdate) {
        // Simulasikan pembaruan informasi profil pengguna
        // Anda dapat menggantinya dengan logika pembaruan profil yang sesuai dengan aplikasi Anda
        return new UserProfile(email, userProfileUpdate.getFirst_name(), userProfileUpdate.getLast_name(), "https://yoururlapi.com/profile.jpeg");
    }
}

