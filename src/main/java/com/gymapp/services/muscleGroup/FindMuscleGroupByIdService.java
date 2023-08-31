package com.gymapp.services.muscleGroup;

import com.gymapp.models.entities.MuscleGroupEntity;
import com.gymapp.repositories.MuscleGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindMuscleGroupByIdService {

    @Autowired
    private MuscleGroupRepository repository;

    public MuscleGroupEntity findById(Long id){
        return repository.findById(id).get();
    }
}