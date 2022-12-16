package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserRoleService {

    Optional<String> createUserRoles(UserRole userRole);

    Optional<UserRole> upDateUserRole(UserRole userRole);


    Optional<List<UserRole>> findAllUserRoles();
}
