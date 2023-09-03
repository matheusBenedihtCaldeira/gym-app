CREATE TABLE tb_workouts (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE tb_workouts_exercises (
    workout_id BIGINT,
    exercise_id BIGINT,
    PRIMARY KEY (workout_id, exercise_id),
    FOREIGN KEY (workout_id) REFERENCES tb_workouts(id),
    FOREIGN KEY (exercise_id) REFERENCES tb_exercises(id)
);