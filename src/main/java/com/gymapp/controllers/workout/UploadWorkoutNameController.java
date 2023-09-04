package com.gymapp.controllers.workout;

import com.gymapp.models.entities.WorkoutEntity;
import com.gymapp.models.requests.UploadWorkoutNameRequest;
import com.gymapp.services.workout.UploadWorkoutNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/update")
public class UploadWorkoutNameController {

    @Autowired
    private UploadWorkoutNameService service;

    @PutMapping(value = "/workout/{id}")
    public ResponseEntity<WorkoutEntity> uploadName(@RequestBody UploadWorkoutNameRequest data, @PathVariable Long id){
        WorkoutEntity workout = service.uploadName(data, id);
        return ResponseEntity.ok().body(workout);
    }
}