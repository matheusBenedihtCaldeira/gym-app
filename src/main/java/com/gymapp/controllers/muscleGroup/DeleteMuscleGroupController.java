package com.gymapp.controllers.muscleGroup;

import com.gymapp.services.muscleGroup.DeleteMuscleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/delete")
public class DeleteMuscleGroupController {

    @Autowired
    private DeleteMuscleGroupService service;

    @DeleteMapping(value = "/musclegroup/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}