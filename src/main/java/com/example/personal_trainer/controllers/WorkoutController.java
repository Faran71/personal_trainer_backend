package com.example.personal_trainer.controllers;

import com.example.personal_trainer.models.Workout;
import com.example.personal_trainer.repositories.WorkoutRepository;
import com.example.personal_trainer.services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "postWorkout/{userId}")
    public ResponseEntity<List<Workout>> postTweet(@PathVariable Long userId, @RequestBody String activity, @RequestBody Integer duration, @RequestBody String description){
        Workout createWorkout = workoutService.createWorkout(userId, activity, duration,description);
        return new ResponseEntity<>(workoutRepository.findAll() ,HttpStatus.CREATED);
    }
}
