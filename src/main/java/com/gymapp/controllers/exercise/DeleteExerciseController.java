package com.gymapp.controllers.exercise;

import com.gymapp.services.exercise.DeleteExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/delete")
@CrossOrigin(origins = "*",  allowedHeaders = "*")
public class DeleteExerciseController {
    @Autowired
    private DeleteExerciseService service;

    @DeleteMapping(value = "/exercise/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}