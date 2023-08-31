package com.gymapp.services.muscleGroup;

import com.gymapp.models.entities.MuscleGroupEntity;
import com.gymapp.repositories.MuscleGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexMuscleGroupService {

    @Autowired
    private MuscleGroupRepository repository;

    public List<MuscleGroupEntity> index(){
        List<MuscleGroupEntity> muscleGroups = repository.findAll();
        return muscleGroups;
    }
}