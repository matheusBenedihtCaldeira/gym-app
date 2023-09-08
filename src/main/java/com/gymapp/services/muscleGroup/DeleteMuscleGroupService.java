package com.gymapp.services.muscleGroup;

import com.gymapp.models.entities.MuscleGroupEntity;
import com.gymapp.repositories.MuscleGroupRepository;
import com.gymapp.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteMuscleGroupService {

    @Autowired
    private MuscleGroupRepository repository;

    public void delete(Long id){
        MuscleGroupEntity muscleGroup = findMuscleGroupById(id);
        repository.delete(muscleGroup);
    }

    public MuscleGroupEntity findMuscleGroupById(Long id){
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Muscle group not found!"));
    }
}