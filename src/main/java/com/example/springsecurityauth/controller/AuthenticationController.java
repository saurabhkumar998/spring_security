package com.example.springsecurityauth.controller;

import com.example.springsecurityauth.model.ApplicationUser;
import com.example.springsecurityauth.dto.LoginResponseDTO;
import com.example.springsecurityauth.dto.RegistrationDTO;
import com.example.springsecurityauth.dto.RegistrationResponseDTO;
import com.example.springsecurityauth.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<RegistrationResponseDTO> registerUser(@RequestBody RegistrationDTO registrationDTO) {
         ApplicationUser response = authenticationService.registerUser(registrationDTO.getUsername(), registrationDTO.getPassword());

        return new ResponseEntity<RegistrationResponseDTO>(new RegistrationResponseDTO(response, "User has been created successfully."), HttpStatus.CREATED);
    }


    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body) {
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }


}
