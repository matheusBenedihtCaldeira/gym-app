package com.gymapp.controllers.exercise;

import com.gymapp.models.entities.ExerciseEntity;
import com.gymapp.services.exercise.IndexExercisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class IndexExercisesController {

    @Autowired
    private IndexExercisesService service;

    @GetMapping(value = "/exercises")
    public ResponseEntity<List<ExerciseEntity>> index(){
        List<ExerciseEntity> exercises = service.index();
        return ResponseEntity.ok().body(exercises);
    }
}