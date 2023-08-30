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
        UserEntity userFromDB = repository.findById(userId).get();
        UserEntity userWithDataToUpdate = new UserEntity();
        BeanUtils.copyProperties(dataDTO, userWithDataToUpdate);
        BeanUtils.copyProperties(userWithDataToUpdate, userFromDB);
        userFromDB.setId(userId);
        return repository.save(userFromDB);
    }

}