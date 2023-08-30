package com.gymapp.services.user;

import com.gymapp.models.entities.UserEntity;
import com.gymapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindUserByIdService {

    @Autowired
    private UserRepository repository;

    public UserEntity findById(Long id){
        return repository.findById(id).get();
    }
}