package com.example.springsecurityauth.dto;

import com.example.springsecurityauth.model.ApplicationUser;

public class RegistrationResponseDTO {
    private ApplicationUser applicationUser;
    private String message;

    public RegistrationResponseDTO() {
    }

    public RegistrationResponseDTO(ApplicationUser applicationUser, String message) {
        this.applicationUser = applicationUser;
        this.message = message;
    }

    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }

    public void setApplicationUser(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
