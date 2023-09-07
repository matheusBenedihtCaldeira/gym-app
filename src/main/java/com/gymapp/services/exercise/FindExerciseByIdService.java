package com.gymapp.services.exercise;

import com.gymapp.models.entities.ExerciseEntity;
import com.gymapp.repositories.ExerciseRepository;
import com.gymapp.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindExerciseByIdService {

    @Autowired
    private ExerciseRepository repository;

    public ExerciseEntity findById(Long id){
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Exercise not found!"));
    }
}