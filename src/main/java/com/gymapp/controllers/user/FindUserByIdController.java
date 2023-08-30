package com.gymapp.controllers.user;

import com.gymapp.models.entities.UserEntity;
import com.gymapp.services.FindUserByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
public class FindUserByIdController {

    @Autowired
    private FindUserByIdService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserEntity> findById(@PathVariable Long id){
        UserEntity user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }

}