package com.gymapp.controllers.exercise;

import com.gymapp.models.dto.ExerciseDTO;
import com.gymapp.models.entities.ExerciseEntity;
import com.gymapp.services.exercise.RegisterExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/register")
public class RegisterExerciseController {

    @Autowired
    private RegisterExerciseService service;

    @PostMapping(value = "/exercise")
    public ResponseEntity<ExerciseEntity> register(@RequestBody ExerciseDTO data){
        ExerciseEntity exercise = service.register(data);
        return ResponseEntity.ok().body(exercise);

    }

}