package com.gymapp.repositories;

import com.gymapp.models.entities.MuscleGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MuscleGroupRepository extends JpaRepository<MuscleGroupEntity, Long> {
}