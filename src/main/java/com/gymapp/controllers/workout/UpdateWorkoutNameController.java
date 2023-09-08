package com.gymapp.controllers.workout;

import com.gymapp.models.entities.WorkoutEntity;
import com.gymapp.models.requests.UpdateWorkoutNameRequest;
import com.gymapp.services.workout.UpdateWorkoutNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/update")
public class UpdateWorkoutNameController {

    @Autowired
    private UpdateWorkoutNameService service;

    @PutMapping(value = "/workout/{id}")
    public ResponseEntity<WorkoutEntity> uploadName(@RequestBody UpdateWorkoutNameRequest data, @PathVariable Long id){
        WorkoutEntity workout = service.update(data, id);
        return ResponseEntity.ok().body(workout);
    }
}