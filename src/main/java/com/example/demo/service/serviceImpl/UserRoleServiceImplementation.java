package com.example.demo.service.serviceImpl;

import com.example.demo.controllers.UserRoleController.UserRoleController;
import com.example.demo.entity.UserRole;
import com.example.demo.repository.UserRoleRepository;
import com.example.demo.service.UserRoleService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleServiceImplementation implements UserRoleService {

    private static final Logger log = LoggerFactory.getLogger(UserRoleServiceImplementation.class);

    @Autowired
    private UserRoleRepository userRoleRepository;


    @Override
    public Optional<String> createUserRoles(UserRole userRole) {
        Optional <String> res = Optional.empty();
        try{
            if (userRole.getUserRole() != null && userRole.getUserType() != null ){
                userRoleRepository.save(userRole);
                res = Optional.of("User Role Created Successfully");
            }

        }catch (Exception e){
            e.printStackTrace();
            log.error("Exception :: "+e.getLocalizedMessage());
            res = Optional.of("Unable to Create UserRole");
        }
        return res;
    }

    @Override
    public Optional<UserRole> upDateUserRole(UserRole userRole) {
        Optional<UserRole> optionalUserRole = Optional.empty();
        try{
            optionalUserRole = userRoleRepository.updateUserRoleUsingId(userRole);

        }catch (Exception e){
            e.printStackTrace();
            log.error("Exception ::"+e.getLocalizedMessage());
        }
        return optionalUserRole;
    }

    @Override
    public Optional<List<UserRole>> findAllUserRoles() {
        Optional<List<UserRole>> userRoleList = Optional.empty();
        try{
            userRoleList = Optional.of(userRoleRepository.findAll());

        }catch (Exception e){
            e.getLocalizedMessage();
            log.error("Exception :: "+e.getLocalizedMessage());
        }
        return userRoleList;
    }
}
