package com.gymapp.services.workout;

import com.gymapp.models.entities.WorkoutEntity;
import com.gymapp.repositories.WorkoutRepository;
import com.gymapp.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteWorkoutService {

    @Autowired
    private WorkoutRepository repository;

    public void delete(Long id){
        WorkoutEntity workout = findWorkoutById(id);
        repository.delete(workout);
    }

    public WorkoutEntity findWorkoutById(Long id){
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Workout not found!"));
    }
}