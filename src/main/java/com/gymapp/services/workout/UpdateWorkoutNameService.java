package com.gymapp.services.workout;

import com.gymapp.models.entities.WorkoutEntity;
import com.gymapp.models.requests.UpdateWorkoutNameRequest;
import com.gymapp.repositories.WorkoutRepository;
import com.gymapp.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateWorkoutNameService {

    @Autowired
    private WorkoutRepository repository;


    public WorkoutEntity update(UpdateWorkoutNameRequest data, Long id){
        WorkoutEntity workout = findWorkoutById(id);
        workout.setName(data.getName());
        return repository.save(workout);
    }

    public WorkoutEntity findWorkoutById(Long id){
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Workout not found!"));
    }
}