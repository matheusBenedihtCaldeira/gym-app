package com.gymapp.services.exercise;

import com.gymapp.models.entities.ExerciseEntity;
import com.gymapp.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindExerciseByIdService {

    @Autowired
    private ExerciseRepository repository;

    public ExerciseEntity findById(Long id){
        return repository.findById(id).get();
    }

}