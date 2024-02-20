package com.example.personal_trainer.repositories;

import com.example.personal_trainer.models.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
}
