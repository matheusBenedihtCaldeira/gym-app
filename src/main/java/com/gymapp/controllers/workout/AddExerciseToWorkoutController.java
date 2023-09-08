package com.gymapp.controllers.workout;

import com.gymapp.models.entities.WorkoutEntity;
import com.gymapp.models.requests.AddExerciseToWorkoutRequest;
import com.gymapp.services.workout.AddExerciseToWorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/workout")
public class AddExerciseToWorkoutController {

    @Autowired
    private AddExerciseToWorkoutService service;

    @PostMapping(value = "/add-exercise/{workoutId}")
    public ResponseEntity<WorkoutEntity> addExercise(@RequestBody AddExerciseToWorkoutRequest data, @PathVariable Long workoutId){
        WorkoutEntity workout = service.addExercise(data, workoutId);
        return ResponseEntity.ok().body(workout);
    }
}
