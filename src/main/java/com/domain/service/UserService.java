package com.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.domain.Exception.DuplicateUsernameException;
import com.domain.model.UserRequest;
import com.domain.model.entities.User;
import com.domain.model.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User daftar(UserRequest userRequest) {
        // Validasi informasi pengguna jika diperlukan
        if (userRepository.findByUsername(userRequest.getUsername()) != null) {
            throw new DuplicateUsernameException("Username sudah digunakan.");
        }

        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setEmail(userRequest.getEmail());

        return userRepository.save(user);
    }
}

