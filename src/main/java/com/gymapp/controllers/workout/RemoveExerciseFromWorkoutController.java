package com.gymapp.controllers.workout;

import com.gymapp.services.workout.RemoveExerciseFromWorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/workout")
public class RemoveExerciseFromWorkoutController {

    @Autowired
    private RemoveExerciseFromWorkoutService service;

    @DeleteMapping(value = "/remove-exercise/{workoutId}/{exerciseId}")
    public ResponseEntity<Void> removeExerciseFromWorkout(@PathVariable Long workoutId, @PathVariable Long exerciseId){
        service.removeExerciseFromWorkout(workoutId, exerciseId);
        return ResponseEntity.noContent().build();
    }
}