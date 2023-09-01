CREATE TABLE tb_exercises (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    muscle_group_id BIGINT,
    FOREIGN KEY (muscle_group_id) REFERENCES tb_muscle_groups(id)
);

ALTER TABLE tb_muscle_groups
ADD FOREIGN KEY (exercise_id) REFERENCES tb_exercises(id);