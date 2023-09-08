package com.gymapp.services.workout;

import com.gymapp.models.dto.WorkoutDTO;
import com.gymapp.models.entities.ExerciseEntity;
import com.gymapp.models.entities.WorkoutEntity;
import com.gymapp.repositories.ExerciseRepository;
import com.gymapp.repositories.WorkoutRepository;
import com.gymapp.services.exceptions.ObjectNotFoundException;
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
        ExerciseEntity exercise = findExerciseById(data.getExerciseId());
        workout.setName(data.getName());
        workout.getExercises().add(exercise);
        return repository.save(workout);
    }

    public ExerciseEntity findExerciseById(Long id){
        return exerciseRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Exercise not found!"));
    }
}