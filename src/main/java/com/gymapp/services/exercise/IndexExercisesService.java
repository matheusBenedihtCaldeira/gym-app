package com.gymapp.services.exercise;

import com.gymapp.models.entities.ExerciseEntity;
import com.gymapp.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexExercisesService {

    @Autowired
    private ExerciseRepository repository;

    public List<ExerciseEntity> index(){
        List<ExerciseEntity> exercises = repository.findAll();
        return exercises;
    }
}