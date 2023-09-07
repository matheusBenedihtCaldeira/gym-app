package com.gymapp.services.user;

import com.gymapp.models.entities.UserEntity;
import com.gymapp.repositories.UserRepository;
import com.gymapp.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserService {

    @Autowired
    private UserRepository repository;

    public void delete(Long id){
        repository.deleteById(id);
    }

    public UserEntity findUserById(Long id){
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User not found!"));
    }
}