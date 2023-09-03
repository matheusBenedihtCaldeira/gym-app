package com.gymapp.services.workout;

import com.gymapp.models.entities.WorkoutEntity;
import com.gymapp.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindWorkoutByIdService {

    @Autowired
    private WorkoutRepository repository;

    public WorkoutEntity findById(Long id){
        return repository.findById(id).get();
    }
}