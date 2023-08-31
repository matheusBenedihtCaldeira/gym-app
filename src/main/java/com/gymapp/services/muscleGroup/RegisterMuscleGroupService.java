package com.gymapp.services.muscleGroup;

import com.gymapp.models.dto.MuscleGroupDTO;
import com.gymapp.models.entities.MuscleGroupEntity;
import com.gymapp.repositories.MuscleGroupRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterMuscleGroupService {

    @Autowired
    private MuscleGroupRepository repository;

    public MuscleGroupEntity register(MuscleGroupDTO dataDTO){
        MuscleGroupEntity muscleGroupEntity = convertDTO(dataDTO);
        return repository.save(muscleGroupEntity);
    }

    public MuscleGroupEntity convertDTO(MuscleGroupDTO data){
        MuscleGroupEntity muscleGroupEntity = new MuscleGroupEntity();
        BeanUtils.copyProperties(data, muscleGroupEntity);
        return muscleGroupEntity;
    }
}