package com.example.personal_trainer.controllers;

import com.example.personal_trainer.models.Workout;
import com.example.personal_trainer.repositories.WorkoutRepository;
import com.example.personal_trainer.services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/workouts"})
public class WorkoutController {

    @Autowired
    WorkoutService workoutService;

    @Autowired
    WorkoutRepository workoutRepository;

    @GetMapping
    public ResponseEntity<List<Workout>> getAllWorkouts(){
        return new ResponseEntity<>(workoutService.findAllWorkouts(), HttpStatus.FOUND);
    }
}
