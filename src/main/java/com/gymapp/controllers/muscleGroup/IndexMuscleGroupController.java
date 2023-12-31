package com.gymapp.controllers.muscleGroup;

import com.gymapp.models.entities.MuscleGroupEntity;
import com.gymapp.services.muscleGroup.IndexMuscleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class IndexMuscleGroupController {

    @Autowired
    private IndexMuscleGroupService service;

    @GetMapping(value = "/musclegroups")
    @CrossOrigin(origins = "*",  allowedHeaders = "*")
    public ResponseEntity<List<MuscleGroupEntity>> index(){
        List<MuscleGroupEntity> muscleGroupEntities = service.index();
        return ResponseEntity.ok().body(muscleGroupEntities);
    }
}