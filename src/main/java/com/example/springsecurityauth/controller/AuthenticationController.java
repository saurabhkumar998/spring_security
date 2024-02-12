package com.example.springsecurityauth.controller;

import com.example.springsecurityauth.model.ApplicationUser;
import com.example.springsecurityauth.model.LoginResponseDTO;
import com.example.springsecurityauth.model.RegistrationDTO;
import com.example.springsecurityauth.service.AuthenticationService;
import com.example.springsecurityauth.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO registrationDTO) {
        return authenticationService.registerUser(registrationDTO.getUsername(), registrationDTO.getPassword());
    }


    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body) {
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }


}
