package com.gymapp.controllers.muscleGroup;

import com.gymapp.models.entities.MuscleGroupEntity;
import com.gymapp.services.muscleGroup.FindMuscleGroupByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/musclegroup")
public class FindMuscleGroupdByIdController {

    @Autowired
    private FindMuscleGroupByIdService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<MuscleGroupEntity> findById(@PathVariable Long id){
        MuscleGroupEntity muscleGroup = service.findById(id);
        return ResponseEntity.ok().body(muscleGroup);
    }

}