//package com.example.sportevents.persistence.entities;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.util.Set;
//import java.util.UUID;
//
//@Entity
//@Getter
//@Setter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//public class Admin {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private UUID id;
//    @Column(unique = true, nullable = false)
//    private String email;
//    @Column(unique = true, nullable = false)
//    private String password;
//    @ManyToMany
//    private Set<Role> roles;
//
//}
