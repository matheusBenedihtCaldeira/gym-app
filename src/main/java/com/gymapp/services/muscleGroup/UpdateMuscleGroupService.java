package com.gymapp.services.muscleGroup;

import com.gymapp.models.dto.MuscleGroupDTO;
import com.gymapp.models.entities.MuscleGroupEntity;
import com.gymapp.repositories.MuscleGroupRepository;
import com.gymapp.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateMuscleGroupService {

    @Autowired
    private MuscleGroupRepository repository;

    public MuscleGroupEntity update(MuscleGroupDTO dataDTO, Long id){
        MuscleGroupEntity muscleGroupToUpdate = convertDTO(dataDTO);
        MuscleGroupEntity muscleGroupFromDB = findMuscleGroupById(id);
        muscleGroupToUpdate.setId(id);
        updateData(muscleGroupToUpdate, muscleGroupFromDB);
        return repository.save(muscleGroupFromDB);
    }

    public MuscleGroupEntity findMuscleGroupById(Long id){
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Muscle group not found!"));
    }

    public MuscleGroupEntity convertDTO(MuscleGroupDTO data){
        MuscleGroupEntity muscleGroup = new MuscleGroupEntity();
        BeanUtils.copyProperties(data, muscleGroup);
        return muscleGroup;
    }

    public void updateData(MuscleGroupEntity dataToUpdate, MuscleGroupEntity dataFromDB){
        BeanUtils.copyProperties(dataToUpdate, dataFromDB);
    }
}