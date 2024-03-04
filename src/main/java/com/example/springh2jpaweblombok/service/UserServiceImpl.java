package com.example.springh2jpaweblombok.service;

import com.example.springh2jpaweblombok.entities.Role;
import com.example.springh2jpaweblombok.entities.User;
import com.example.springh2jpaweblombok.repositories.RoleRepository;
import com.example.springh2jpaweblombok.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
    private  final  UserRepository userRepository;
    private  final RoleRepository roleRepository;


    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());

        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRolename(roleName);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user=findUserByUserName(username);
        Role role=findRoleByRoleName(roleName);
        if(user.getRoles()!=null) {
            user.getRoles().add(role);
            role.getUsers().add(user);
        }
//        userRepository.save(user);
    }

    @Override
    public User authenticate(String username, String password) {
        User user=userRepository.findByUsername(username);
        if(user==null)  throw  new RuntimeException("Bad credentials");
        if(user.getPassword().equals(password)){
            return user;
        }  throw  new RuntimeException("Bad credentials");


    }
}
