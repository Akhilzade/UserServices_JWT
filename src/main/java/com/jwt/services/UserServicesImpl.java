package com.jwt.services;

import com.jwt.Repo.RoleRepo;
import com.jwt.Repo.UserRepo;
import com.jwt.models.Role;
import com.jwt.models.User;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service  @RequiredArgsConstructor @Transactional @Slf4j
public class UserServicesImpl implements UserServices{

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RoleRepo roleRepo;

	@Override
	public User saveUser(User user) {
		log.info(" Saving the new user{} in database",user.getName());
		return userRepo.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		log.info(" Saving the new role{} in database",role.getName());
		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String username, String name) {
		log.info(" Adding the  user{} and role {} in database",username,name);
		User user=userRepo.findByUsername(username);
		Role role=roleRepo.findByName(name);
		user.getRole().add(role);
	}

	@Override
	public User getUser(String username) {
		log.info(" Fetching the  user{} in database",username);
		return userRepo.findByUsername(username);
	}

	@Override
	public List<User> getUsers() {
		log.info(" Fetching the all");

		return userRepo.findAll();
	}
}
