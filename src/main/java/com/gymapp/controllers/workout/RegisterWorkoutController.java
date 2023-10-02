package com.gymapp.controllers.workout;

import com.gymapp.models.dto.WorkoutDTO;
import com.gymapp.models.entities.WorkoutEntity;
import com.gymapp.services.exercise.RegisterExerciseService;
import com.gymapp.services.workout.RegisterWorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/register")
@CrossOrigin(origins = "*",  allowedHeaders = "*")
public class RegisterWorkoutController {

    @Autowired
    private RegisterWorkoutService service;

    @PostMapping(value = "/workout")
    public ResponseEntity<WorkoutEntity> register(@RequestBody WorkoutDTO data){
        WorkoutEntity workout = service.register(data);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(workout.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}