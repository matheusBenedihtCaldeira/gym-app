package com.gymapp.controllers.muscleGroup;

import com.gymapp.models.dto.MuscleGroupDTO;
import com.gymapp.models.entities.MuscleGroupEntity;
import com.gymapp.services.muscleGroup.RegisterMuscleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/register")
public class RegisterMuscleGroupController {

    @Autowired
    private RegisterMuscleGroupService service;

    @PostMapping(value = "/musclegroup")
    public ResponseEntity<MuscleGroupEntity> register(@RequestBody MuscleGroupDTO dataDTO){
        MuscleGroupEntity muscleGroupEntity = service.register(dataDTO);
        return ResponseEntity.ok().body(muscleGroupEntity);
    }

}