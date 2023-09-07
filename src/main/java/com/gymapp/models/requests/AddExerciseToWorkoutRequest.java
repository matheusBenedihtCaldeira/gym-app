package com.gymapp.models.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddExerciseToWorkoutRequest {

    private Long exerciseId;
}