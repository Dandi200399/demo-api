package com.domain.model.entities;

public class UserProfile {
    private String email;
    private String first_name;
    private String last_name;
    private String profile_image;

    public UserProfile() {
        // Konstruktor kosong diperlukan untuk deserialisasi JSON
    }

    public UserProfile(String email, String first_name, String last_name, String profile_image) {
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.profile_image = profile_image;
    }

    // Buat getter dan setter untuk semua properti

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }
}

