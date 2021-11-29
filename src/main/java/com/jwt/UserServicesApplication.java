package com.jwt;

import com.jwt.models.Role;
import com.jwt.models.User;
import com.jwt.services.UserServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServicesApplication.class, args);
	}


	@Bean
	PasswordEncoder passwordEncoder(){

		return new BCryptPasswordEncoder();
	}

//	@Bean
//	CommandLineRunner run(UserServices userServices){
//return args -> {
//
//	userServices.saveRole(new Role(null,"ROLE_ADMIN"));
//	userServices.saveRole(new Role(null,"ROLE_USER"));
//	userServices.saveRole(new Role(null,"ROLE_CLIENT"));
//	userServices.saveRole(new Role(null,"ROLE_MANAGER"));
//
//	userServices.saveUser(new User(null,"Akhil","a@gam","123",new ArrayList<>()));
//	userServices.saveUser(new User(null,"Nikhil","n216bs","123",new ArrayList<>()));
//	userServices.saveUser(new User(null,"Shyam","2svb","123",new ArrayList<>()));
//	userServices.saveUser(new User(null,"Ram","are@gam","123",new ArrayList<>()));
//
//	userServices.addRoleToUser("Akhil","ROLE_ADMIN");
//	userServices.addRoleToUser("Akhil","ROLE_MANAGER");
//	userServices.addRoleToUser("Nikhil","ROLE_USER");
//	userServices.addRoleToUser("RAM","ROLE_CLIENT");
//
//};
// }

}
