package com.domain.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.domain.model.ApiResponse;
import com.domain.model.RegistrationRequest;
import com.domain.service.UserService;

@RestController
public class RegistrationController {
    private final UserService userService;

    
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public ResponseEntity<ApiResponse> register(@RequestBody RegistrationRequest request) {
        // Metode POST
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

    @GetMapping("/registration")
    public ResponseEntity<String> getRegistrationPage() {
        // Metode GET
        // Di sini, dapat mengembalikan halaman HTML atau pesan yang  inginkan
        return ResponseEntity.ok("Ini adalah halaman pendaftaran.");
    }

    private boolean isValidEmail(String email) {
        // Validasi format email menggunakan ekspresi reguler
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(regex);
    }
}
