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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/register")
public class RegisterExerciseController {

    @Autowired
    private RegisterExerciseService service;

    @PostMapping(value = "/exercise")
    public ResponseEntity<ExerciseEntity> register(@RequestBody ExerciseDTO data){
        ExerciseEntity exercise = service.register(data);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(exercise.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

}