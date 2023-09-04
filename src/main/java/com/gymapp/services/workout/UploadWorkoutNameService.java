package com.gymapp.services.workout;

import com.gymapp.models.entities.WorkoutEntity;
import com.gymapp.models.requests.UploadWorkoutNameRequest;
import com.gymapp.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadWorkoutNameService {

    @Autowired
    private WorkoutRepository repository;


    public WorkoutEntity uploadName(UploadWorkoutNameRequest data, Long id){
        WorkoutEntity workout = repository.findById(id).get();
        workout.setName(data.getName());
        return repository.save(workout);
    }
}