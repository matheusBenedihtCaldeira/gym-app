package com.gymapp.controllers.workout;

import com.gymapp.models.dto.WorkoutDTO;
import com.gymapp.models.entities.WorkoutEntity;
import com.gymapp.services.exercise.RegisterExerciseService;
import com.gymapp.services.workout.RegisterWorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/register")
public class RegisterWorkoutController {

    @Autowired
    private RegisterWorkoutService service;

    @PostMapping(value = "/workout")
    public ResponseEntity<WorkoutEntity> register(@RequestBody WorkoutDTO data){
        WorkoutEntity workout = service.register(data);
        return ResponseEntity.ok().body(workout);
    }
}