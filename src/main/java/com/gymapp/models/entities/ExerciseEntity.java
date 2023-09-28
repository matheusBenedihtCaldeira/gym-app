package com.gymapp.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "muscle_group_id")
    private MuscleGroupEntity muscleGroup;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MuscleGroupEntity getMuscleGroup() {
        return muscleGroup;
    }

    public void setMuscleGroup(MuscleGroupEntity muscleGroup) {
        this.muscleGroup = muscleGroup;
    }
}