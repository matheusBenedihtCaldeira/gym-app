package com.gymapp.services.workout;

import com.gymapp.models.dto.WorkoutDTO;
import com.gymapp.models.entities.ExerciseEntity;
import com.gymapp.models.entities.WorkoutEntity;
import com.gymapp.repositories.ExerciseRepository;
import com.gymapp.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterWorkoutService {

    @Autowired
    private WorkoutRepository repository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    public WorkoutEntity register(WorkoutDTO data){
        WorkoutEntity workout = new WorkoutEntity();
        ExerciseEntity exercise = exerciseRepository.findById(data.getExerciseId()).get();
        workout.setName(data.getName());
        workout.getExercises().add(exercise);
        return repository.save(workout);
    }
}