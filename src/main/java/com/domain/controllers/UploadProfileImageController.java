package com.domain.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.domain.model.ApiResponse;
import com.domain.model.entities.UserProfile;

@RestController
public class UploadProfileImageController {

    @PutMapping("/profile/image")
    public ResponseEntity<ApiResponse> uploadProfileImage(@RequestHeader("Authorization") String authorizationHeader, @RequestPart("file") MultipartFile file) {
        // Validasi Token
        String token = extractTokenFromHeader(authorizationHeader);
        if (token == null) {
            return ResponseEntity.status(401).body(new ApiResponse(108, "Token tidak valid atau kadaluwarsa", null));
        }

        // Dekode Token dan dapatkan email dari payload
        String email = decodeTokenAndGetEmail(token);

        // Validasi format gambar (jpeg atau png)
        if (!isValidImageFormat(file)) {
            return ResponseEntity.status(400).body(new ApiResponse(102, "Format Image tidak sesuai", null));
        }

        // Simulasikan pembaruan gambar profil pengguna
        String imageUrl = updateProfileImage(email, file);

        if (imageUrl != null) {
            return ResponseEntity.ok(new ApiResponse(0, "Update Profile Image berhasil", new UserProfile(email, null, null, imageUrl)));
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
        // harus menggunakan kunci rahasia yang sesuai untuk verifikasi token
        // Misalnya: return getEmailFromToken(token, "yourSecretKey")
        return "user@nutech-integrasi.com";
    }

    private boolean isValidImageFormat(MultipartFile file) {
        // Validasi format gambar (jpeg atau png)
        String contentType = file.getContentType();
        return contentType != null && (contentType.equals("image/jpeg") || contentType.equals("image/png"));
    }

    private String updateProfileImage(String email, MultipartFile file) {
        // Simulasikan pembaruan gambar profil pengguna
        // Contoh: saveImageToServerAndGetUrl(email, file)
        return "https://yoururlapi.com/profile-updated.jpeg";
    }
}

