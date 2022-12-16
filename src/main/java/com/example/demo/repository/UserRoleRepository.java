package com.example.demo.repository;

import com.example.demo.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {


    @Query(value = "SELECT u FROM User u WHERE u.status = 1", nativeQuery = true)
    Optional<UserRole> updateUserRoleUsingId(UserRole userRole);
}
