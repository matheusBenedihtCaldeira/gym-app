package com.gymapp.controllers.user;

import com.gymapp.models.entities.UserEntity;
import com.gymapp.services.user.IndexUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/index")
public class IndexUsersController {

    @Autowired
    private IndexUsersService service;

    @GetMapping(value = "/users")
    public ResponseEntity<List<UserEntity>> index(){
        List<UserEntity> users = service.index();
        return ResponseEntity.ok().body(users);
    }
}