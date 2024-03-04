package com.example.springh2jpaweblombok.service;

import com.example.springh2jpaweblombok.entities.Role;
import com.example.springh2jpaweblombok.entities.User;

public interface IUserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String username,String roleName);
    User authenticate(String username,String password);
}
