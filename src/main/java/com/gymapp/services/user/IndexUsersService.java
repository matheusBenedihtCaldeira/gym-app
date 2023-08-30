package com.gymapp.services.user;

import com.gymapp.models.entities.UserEntity;
import com.gymapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexUsersService {

    @Autowired
    private UserRepository repository;

    public List<UserEntity> index(){
        List<UserEntity> users = repository.findAll();
        return users;
    }
}