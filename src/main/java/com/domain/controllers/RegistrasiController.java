package com.domain.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.domain.model.UserRequest;

@RestController
@RequestMapping("/api/registrasi")
public class RegistrasiController {

    @PostMapping("/daftar")
    public ResponseEntity<?> daftar(@RequestBody UserRequest userRequest) {
        // Validasi input userRequest
        // Simpan informasi pengguna ke basis data menggunakan userService
        return ResponseEntity.ok("Pendaftaran berhasil");
    }

    @GetMapping("/daftar")
    public ResponseEntity<?> daftarGet() {
        // Implementasi metode GET di sini
        return ResponseEntity.ok("Pendaftaran berhasil (metode GET)");
    }
}
