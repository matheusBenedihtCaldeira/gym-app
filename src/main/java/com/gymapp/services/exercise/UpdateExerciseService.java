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
public class UpdateExerciseService {

    @Autowired
    private ExerciseRepository repository;

    @Autowired
    private MuscleGroupRepository muscleGroupRepository;

    public ExerciseEntity update(ExerciseDTO dataDTO, Long exerciseID){
        ExerciseEntity exerciseFromDB = repository.findById(exerciseID).get();
        ExerciseEntity exerciseToUpdate = new ExerciseEntity();
        MuscleGroupEntity muscleGroup = muscleGroupRepository.findById(dataDTO.getMuscleGroupId()).get();
        exerciseToUpdate.setName(dataDTO.getName());
        exerciseToUpdate.setDescription(dataDTO.getDescription());
        exerciseToUpdate.setMuscleGroup(muscleGroup);
        BeanUtils.copyProperties(exerciseToUpdate, exerciseFromDB);
        exerciseFromDB.setId(exerciseID);
        return repository.save(exerciseFromDB);
    }
}