package com.example.springsecurityauth;

import com.example.springsecurityauth.model.ApplicationUser;
import com.example.springsecurityauth.model.Role;
import com.example.springsecurityauth.repository.RoleRepository;
import com.example.springsecurityauth.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringsecurityauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityauthApplication.class, args);
	}



	/**
	 *
	 * // making use of command line runner to initialize the user and its role when the application starts,
	 * this is just for testing, if the database contains teh user details then we dont need to use this
	 * @param roleRepository
	 * @param userRepository
	 * @param passwordEncoder
	 * @return CommandLineRunner
	 */


	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {

		return  args -> {

			if(roleRepository.findByAuthority("ADMIN").isPresent()) return;

			roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));

			//Set<Role> roles = new HashSet<>();
			//roles.add(adminRole);

			//ApplicationUser admin = new ApplicationUser(1, "admin", passwordEncoder.encode("password"), roles);
			//userRepository.save(admin);
		};
	}


}
