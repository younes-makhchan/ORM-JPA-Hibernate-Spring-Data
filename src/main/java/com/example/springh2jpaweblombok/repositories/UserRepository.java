package com.example.springh2jpaweblombok.repositories;

import com.example.springh2jpaweblombok.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,String> {
    User findByUsername(String userName);


}
