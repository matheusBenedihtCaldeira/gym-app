package com.gymapp.services.workout;

import com.gymapp.models.entities.ExerciseEntity;
import com.gymapp.models.entities.WorkoutEntity;
import com.gymapp.repositories.ExerciseRepository;
import com.gymapp.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoveExerciseFromWorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    public void removeExerciseFromWorkout(Long workoutId, Long exerciseId){
        WorkoutEntity workout = workoutRepository.findById(workoutId).get();
        ExerciseEntity exercise = exerciseRepository.findById(exerciseId).get();
        workout.getExercises().remove(exercise);
        workoutRepository.save(workout);
    }
}