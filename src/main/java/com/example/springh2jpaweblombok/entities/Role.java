package com.example.springh2jpaweblombok.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String desc;
    @Column(length = 20,unique = true)
    private String rolename;
    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable( name = "USERS_ROLES")
    //excluding it in toString , so we avoid the  in
    @ToString.Exclude
    private List<User> users = new ArrayList<>() ;
}
