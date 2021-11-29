package com.jwt.services;

import com.jwt.models.Role;
import com.jwt.models.User;

import java.util.List;

public interface UserServices {

	User saveUser(User user);
	Role saveRole(Role role);
	void addRoleToUser(String username,String name);
	User getUser(String username);
	List<User> getUsers();

}
