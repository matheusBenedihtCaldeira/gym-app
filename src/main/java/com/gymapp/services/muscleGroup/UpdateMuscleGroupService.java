package com.gymapp.services.muscleGroup;

import com.gymapp.models.dto.MuscleGroupDTO;
import com.gymapp.models.entities.MuscleGroupEntity;
import com.gymapp.repositories.MuscleGroupRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateMuscleGroupService {

    @Autowired
    private MuscleGroupRepository repository;

    public MuscleGroupEntity update(MuscleGroupDTO dataDTO, Long id){
        MuscleGroupEntity muscleGroupToUpdate = new MuscleGroupEntity();
        MuscleGroupEntity muscleGroupUpdated = repository.findById(id).get();
        BeanUtils.copyProperties(dataDTO, muscleGroupToUpdate);
        muscleGroupToUpdate.setId(id);
        BeanUtils.copyProperties(muscleGroupToUpdate, muscleGroupUpdated);
        return repository.save(muscleGroupUpdated);
    }

}