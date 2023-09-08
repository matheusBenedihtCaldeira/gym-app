package com.gymapp.controllers.muscleGroup;

import com.gymapp.models.dto.MuscleGroupDTO;
import com.gymapp.models.entities.MuscleGroupEntity;
import com.gymapp.services.muscleGroup.UpdateMuscleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/update")
public class UpdateMuscleGroupController {

    @Autowired
    private UpdateMuscleGroupService service;

    @PutMapping(value = "/musclegroup/{id}")
    public ResponseEntity<MuscleGroupEntity> update(@RequestBody MuscleGroupDTO data, @PathVariable Long id){
        MuscleGroupEntity muscleGroupEntity = service.update(data, id);
        return ResponseEntity.ok().body(muscleGroupEntity);
    }
}