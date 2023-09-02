package com.gymapp.services.exercise;

import com.gymapp.models.dto.ExerciseDTO;
import com.gymapp.models.entities.ExerciseEntity;
import com.gymapp.models.entities.MuscleGroupEntity;
import com.gymapp.repositories.ExerciseRepository;
import com.gymapp.repositories.MuscleGroupRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private MuscleGroupRepository muscleGroupRepository;

    public ExerciseEntity register(ExerciseDTO dataDTO){
        ExerciseEntity exercise = new ExerciseEntity();
        MuscleGroupEntity muscleGroup = muscleGroupRepository.findById(dataDTO.getMuscleGroupId()).get();
        exercise.setName(dataDTO.getName());
        exercise.setDescription(dataDTO.getDescription());
        exercise.setMuscleGroup(muscleGroup);
        return exerciseRepository.save(exercise);
    }
}