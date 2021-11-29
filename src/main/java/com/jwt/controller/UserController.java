package com.jwt.controller;

import com.jwt.models.Role;
import com.jwt.models.User;
import com.jwt.services.UserServices;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController @RequiredArgsConstructor @RequestMapping("/api")
public class UserController {

	@Autowired
	private UserServices userServices;

   @GetMapping("/user")
	public ResponseEntity<List<User>> getUser(){
		return ResponseEntity.ok().body(userServices.getUsers());
	}

	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/save").toString());
		return ResponseEntity.created(uri).body(userServices.saveUser(user));
	}

	@PostMapping("/saver")
	public ResponseEntity<Role> saveRole(@RequestBody Role role){
		URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/saver").toString());
		return ResponseEntity.created(uri).body(userServices.saveRole(role));
	}

	@PostMapping("/addToUser")
	public ResponseEntity<?> addUserToRole(@RequestBody RoleToUserAdd toUserAdd){
		userServices.addRoleToUser(toUserAdd.getUsername(),toUserAdd.getName());
	   return ResponseEntity.ok().build();
	}


}

@Data
class RoleToUserAdd{
	private String username;
	private String name;
}