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
        WorkoutEntity workout = workoutRepository.findById(workoutID).get();
        ExerciseEntity exercise = exerciseRepository.findById(data.getExerciseId()).get();
        workout.getExercises().add(exercise);
        return workoutRepository.save(workout);
    }
}