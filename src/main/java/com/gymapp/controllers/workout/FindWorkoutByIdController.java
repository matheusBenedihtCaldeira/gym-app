package com.gymapp.controllers.workout;

import com.gymapp.models.entities.WorkoutEntity;
import com.gymapp.services.workout.FindWorkoutByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/workout")
public class FindWorkoutByIdController {

    @Autowired
    private FindWorkoutByIdService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<WorkoutEntity> findById(@PathVariable Long id){
        WorkoutEntity workout = service.findById(id);
        return ResponseEntity.ok().body(workout);
    }
}