package com.gymapp.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_exercises")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "muscle_group_id")
    private List<MuscleGroupEntity> muscleGroup = new ArrayList<>();
}