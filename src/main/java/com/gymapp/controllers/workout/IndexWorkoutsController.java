package com.gymapp.controllers.workout;

import com.gymapp.models.entities.WorkoutEntity;
import com.gymapp.services.workout.IndexWorkoutsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/index")
@CrossOrigin(origins = "*",  allowedHeaders = "*")
public class IndexWorkoutsController {

    @Autowired
    private IndexWorkoutsService service;

    @GetMapping(value = "/workouts")
    public ResponseEntity<List<WorkoutEntity>> index(){
        List<WorkoutEntity> index = service.index();
        return ResponseEntity.ok().body(index);
    }
}