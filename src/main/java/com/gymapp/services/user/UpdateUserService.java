package com.gymapp.services.user;

import com.gymapp.models.dto.UserDTO;
import com.gymapp.models.entities.UserEntity;
import com.gymapp.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserService {

    @Autowired
    private UserRepository repository;

    public UserEntity update(UserDTO dataDTO, Long userId){
        UserEntity userFromDB = findUserById(userId);
        UserEntity userWithDataToUpdate = convertDTO(dataDTO);
        updateData(userFromDB, userWithDataToUpdate);
        userFromDB.setId(userId);
        return repository.save(userFromDB);
    }

    public void updateData(UserEntity userUpdated, UserEntity userWithDataToUpdate){
        BeanUtils.copyProperties(userWithDataToUpdate, userUpdated);
    }

    public UserEntity findUserById(Long id){
        return repository.findById(id).get();
    }

    public UserEntity convertDTO(UserDTO dataDTO){
        UserEntity user = new UserEntity();
        BeanUtils.copyProperties(dataDTO, user);
        return user;
    }
}