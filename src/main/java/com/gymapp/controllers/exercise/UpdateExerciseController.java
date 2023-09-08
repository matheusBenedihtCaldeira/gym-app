package com.gymapp.controllers.exercise;

import com.gymapp.models.dto.ExerciseDTO;
import com.gymapp.models.entities.ExerciseEntity;
import com.gymapp.services.exercise.UpdateExerciseService;
import com.gymapp.services.muscleGroup.UpdateMuscleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/update")
public class UpdateExerciseController {

    @Autowired
    private UpdateExerciseService service;

    @PutMapping(value = "/exercise/{id}")
    public ResponseEntity<ExerciseEntity> update(@RequestBody ExerciseDTO data, @PathVariable Long id){
        ExerciseEntity exercise = service.update(data, id);
        return ResponseEntity.ok().body(exercise);
    }
}