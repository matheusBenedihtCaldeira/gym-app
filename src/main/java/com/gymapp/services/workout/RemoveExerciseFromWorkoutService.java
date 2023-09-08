package com.gymapp.services.workout;

import com.gymapp.models.entities.ExerciseEntity;
import com.gymapp.models.entities.WorkoutEntity;
import com.gymapp.repositories.ExerciseRepository;
import com.gymapp.repositories.WorkoutRepository;
import com.gymapp.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoveExerciseFromWorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    public void removeExerciseFromWorkout(Long workoutId, Long exerciseId){
        WorkoutEntity workout = findWorkoutById(workoutId);
        ExerciseEntity exercise = findExerciseById(exerciseId);
        workout.getExercises().remove(exercise);
        workoutRepository.save(workout);
    }

    public WorkoutEntity findWorkoutById(Long id){
        return workoutRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Workout not found!"));
    }

    public ExerciseEntity findExerciseById(Long id){
        return exerciseRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Exercise not found!"));
    }
}