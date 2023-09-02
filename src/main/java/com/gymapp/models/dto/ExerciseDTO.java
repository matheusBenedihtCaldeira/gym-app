package com.gymapp.models.dto;

import com.gymapp.models.entities.MuscleGroupEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseDTO {

    private String name;
    private String description;
    private Long muscleGroupId;
}