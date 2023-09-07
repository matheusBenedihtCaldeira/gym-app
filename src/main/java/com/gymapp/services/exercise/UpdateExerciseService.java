package com.gymapp.services.exercise;

import com.gymapp.models.dto.ExerciseDTO;
import com.gymapp.models.entities.ExerciseEntity;
import com.gymapp.models.entities.MuscleGroupEntity;
import com.gymapp.repositories.ExerciseRepository;
import com.gymapp.repositories.MuscleGroupRepository;
import com.gymapp.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private MuscleGroupRepository muscleGroupRepository;

    public ExerciseEntity update(ExerciseDTO dataDTO, Long exerciseID){
        ExerciseEntity exerciseFromDB = findExerciseById(exerciseID);
        ExerciseEntity exerciseToUpdate = new ExerciseEntity();
        MuscleGroupEntity muscleGroup = findMuscleGroupById(dataDTO.getMuscleGroupId());
        exerciseToUpdate.setName(dataDTO.getName());
        exerciseToUpdate.setDescription(dataDTO.getDescription());
        exerciseToUpdate.setMuscleGroup(muscleGroup);
        updateData(exerciseToUpdate, exerciseFromDB);
        exerciseFromDB.setId(exerciseID);
        return exerciseRepository.save(exerciseFromDB);
    }

    public ExerciseEntity findExerciseById(Long id){
        return exerciseRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Exercise not found!"));
    }

    public MuscleGroupEntity findMuscleGroupById(Long id){
        return muscleGroupRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Muscle groupt not foun!"));
    }

    public void updateData(ExerciseEntity dataToUpdate, ExerciseEntity dataFromDB){
        BeanUtils.copyProperties(dataToUpdate, dataFromDB);
    }
}