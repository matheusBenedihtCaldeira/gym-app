package com.gymapp.services.workout;

import com.gymapp.models.entities.ExerciseEntity;
import com.gymapp.models.entities.WorkoutEntity;
import com.gymapp.models.requests.AddExerciseToWorkoutRequest;
import com.gymapp.repositories.ExerciseRepository;
import com.gymapp.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddExerciseToWorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    public WorkoutEntity addExercise(AddExerciseToWorkoutRequest data, Long workoutID){
        WorkoutEntity workout = findWorkoutById(workoutID);
        ExerciseEntity exercise = findExerciseById(data.getExerciseId());
        workout.getExercises().add(exercise);
        return workoutRepository.save(workout);
    }

    public ExerciseEntity findExerciseById(Long id){
        return exerciseRepository.findById(id).get();
    }

    public WorkoutEntity findWorkoutById(Long id){
        return workoutRepository.findById(id).get();
    }
}