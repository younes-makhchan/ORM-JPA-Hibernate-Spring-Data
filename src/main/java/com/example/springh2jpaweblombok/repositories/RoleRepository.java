package com.example.springh2jpaweblombok.repositories;

import com.example.springh2jpaweblombok.entities.Patient;
import com.example.springh2jpaweblombok.entities.Role;
import com.example.springh2jpaweblombok.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,String> {

    Role findByRolename(String rolename);

}
