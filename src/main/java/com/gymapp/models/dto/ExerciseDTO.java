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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getMuscleGroupId() {
        return muscleGroupId;
    }

    public void setMuscleGroupId(Long muscleGroupId) {
        this.muscleGroupId = muscleGroupId;
    }
}