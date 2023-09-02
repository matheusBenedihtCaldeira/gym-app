package com.gymapp.services.exercise;

import com.gymapp.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteExerciseService {

    @Autowired
    private ExerciseRepository repository;

    public void delete(Long id){
        repository.deleteById(id);
    }
}