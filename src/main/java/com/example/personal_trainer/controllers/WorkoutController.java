package com.example.personal_trainer.controllers;

import com.example.personal_trainer.models.User;
import com.example.personal_trainer.models.Workout;
import com.example.personal_trainer.models.WorkoutDTO;
import com.example.personal_trainer.repositories.UserRepository;
import com.example.personal_trainer.repositories.WorkoutRepository;
import com.example.personal_trainer.services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/workouts"})
public class WorkoutController {

    @Autowired
    WorkoutService workoutService;

    @Autowired
    WorkoutRepository workoutRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<Workout>> getAllWorkouts(){
        return new ResponseEntity<>(workoutService.findAllWorkouts(), HttpStatus.FOUND);
    }

    @PostMapping(value = "postWorkout/{userId}")
    public ResponseEntity<Optional<User>> postWorkout(@PathVariable Long userId, @RequestBody WorkoutDTO workoutDTO){
//        Instead of returning all workouts I am going to return the user info as the user object contains all information needed.
        Workout createWorkout = workoutService.createWorkout(userId, workoutDTO.getActivity(), workoutDTO.getDuration(),workoutDTO.getDescription());
        return new ResponseEntity<>(userRepository.findById(userId) ,HttpStatus.CREATED);
    }
}
