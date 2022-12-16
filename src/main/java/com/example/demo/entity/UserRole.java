package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "User_Role")
public class UserRole {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column(name = "userRole")
    private String userRole;

    @Column(name = "typeId")
    private Integer userType;





}
