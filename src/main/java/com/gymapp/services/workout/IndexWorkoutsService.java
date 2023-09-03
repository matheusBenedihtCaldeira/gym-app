package com.gymapp.services.workout;

import com.gymapp.models.entities.WorkoutEntity;
import com.gymapp.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexWorkoutsService {

    @Autowired
    private WorkoutRepository repository;

    public List<WorkoutEntity> index(){
        List<WorkoutEntity> workouts = repository.findAll();
        return workouts;
    }
}