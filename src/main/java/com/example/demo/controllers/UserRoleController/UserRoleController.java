package com.example.demo.controllers.UserRoleController;

import com.example.demo.entity.UserRole;
import com.example.demo.service.UserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserRoleController {

    private static final Logger log = LoggerFactory.getLogger(UserRoleController.class);


    @Autowired
    private UserRoleService userRoleService;

    @PostMapping("/createUserRole")
    public ResponseEntity createUserRoles(@RequestBody UserRole userRole){
        Optional<String> response ;
        ResponseEntity responseEntity = null;
        try{
             response = userRoleService.createUserRoles(userRole);
             responseEntity = ResponseEntity.status(200).body(response);

        }catch (Exception e){
            e.printStackTrace();
            log.error("Exception :: "+e.getLocalizedMessage());

            responseEntity = ResponseEntity.status(400).body(null);
        }
        return responseEntity;
    }

    @PostMapping("/getAllRoles")
    public Optional<List<UserRole>> getAllUserRoles(){
        Optional<List<UserRole>> userRoleList = Optional.empty();
        try{
            userRoleList = userRoleService.findAllUserRoles();
        }catch (NullPointerException e){
            e.getLocalizedMessage();
        }
        return userRoleList;
    }



}
