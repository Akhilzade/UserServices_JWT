package com.jwt.Repo;


import com.jwt.models.Role;
import com.jwt.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Integer> {
	Role findByName(String name);

}