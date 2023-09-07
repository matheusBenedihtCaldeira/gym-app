package com.gymapp.services.user;

import com.gymapp.models.dto.UserDTO;
import com.gymapp.models.entities.UserEntity;
import com.gymapp.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService {

    @Autowired
    private UserRepository repository;

    public UserEntity register(UserDTO dataDTO){
        UserEntity user = convertDTO(dataDTO);
        return repository.save(user);
    }

    public UserEntity convertDTO(UserDTO dataDTO){
        UserEntity user = new UserEntity();
        BeanUtils.copyProperties(dataDTO, user);
        return user;
    }
}