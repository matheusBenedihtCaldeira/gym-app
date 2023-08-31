package com.gymapp.services.muscleGroup;

import com.gymapp.repositories.MuscleGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteMuscleGroupService {

    @Autowired
    private MuscleGroupRepository repository;

    public void delete(Long id){
        repository.deleteById(id);
    }
}