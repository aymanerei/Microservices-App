package com.example.securityservice;

import com.example.securityservice.model.Role;
import com.example.securityservice.model.User;
import com.example.securityservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.ArrayList;

@SpringBootApplication
public class SecurityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityServiceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService, RepositoryRestConfiguration restConfiguration) {

		// employeeService.saveEmployee(new Employee(1L, "Aymane", "Reida", "aymanerei53@gmail.com"));
		// Employee employee = employeeService.getEmployee(1L).get();
		// System.out.println(employee);

		return args -> {
			restConfiguration.exposeIdsFor(User.class);
			/*userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveUser(new User(null, "admin", "admin", "admin@admin.com", new ArrayList<>()));
			userService.addRoleToUser("admin", "ROLE_USER");
			userService.addRoleToUser("admin", "ROLE_ADMIN");*/
		};

	}
}
