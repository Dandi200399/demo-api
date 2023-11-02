package com.domain.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.domain.model.ApiResponse;
import com.domain.model.RegistrationRequest;
import com.domain.service.UserService;

@RestController
public class RegistrationController {
    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public ResponseEntity<ApiResponse> register(@RequestBody RegistrationRequest request) {
        // Validasi email dan password
        if (!isValidEmail(request.getEmail())) {
            return ResponseEntity.badRequest().body(new ApiResponse(102, "Parameter email tidak sesuai format", null));
        }

        if (request.getPassword().length() < 8) {
            return ResponseEntity.badRequest().body(new ApiResponse(103, "Panjang password kurang dari 8 karakter", null));
        }

        // Simpan data pengguna ke database menggunakan prepared statement
        userService.registerUser(request.getEmail(), request.getFirst_name(), request.getLast_name(), request.getPassword());

        return ResponseEntity.ok(new ApiResponse(0, "Registrasi berhasil silahkan login", null));
    }

    private boolean isValidEmail(String email) {
        return false;
    }
}
