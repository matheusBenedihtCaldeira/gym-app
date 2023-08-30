package com.gymapp.controllers.user;

import com.gymapp.models.dto.UserDTO;
import com.gymapp.models.entities.UserEntity;
import com.gymapp.services.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/register")
public class RegisterUserController {

    @Autowired
    private RegisterUserService service;

    @PostMapping(value = "/user")
    public ResponseEntity<UserEntity> register(@RequestBody UserDTO data){
        UserEntity user = service.register(data);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}