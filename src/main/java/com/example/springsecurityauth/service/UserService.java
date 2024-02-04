package com.example.springsecurityauth.service;

import com.example.springsecurityauth.model.ApplicationUser;
import com.example.springsecurityauth.model.Role;
import com.example.springsecurityauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("Inside UserService->UserDetailsService");

        return userRepository.findByUsername(username)
                .orElseThrow( () -> new UsernameNotFoundException("user is not valid"));
    }
}
