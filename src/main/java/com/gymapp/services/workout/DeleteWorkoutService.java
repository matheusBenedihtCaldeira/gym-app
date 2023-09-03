package com.gymapp.services.workout;

import com.gymapp.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteWorkoutService {

    @Autowired
    private WorkoutRepository repository;

    public void delete(Long id){
        repository.deleteById(id);
    }
}