package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "User")
public class User {

    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password")
    private String password;

    @Column(name = "gender")
    private Integer gender;

//    @OneToOne
//    @JoinColumn(name = "id")
    @Column(name = "user_role")
    private String userRole;

    @Column(name = "address")
    private String address;

    @Column(name = "area")
    private String area;

    @Column(name = "city")
    private Integer city;









}
