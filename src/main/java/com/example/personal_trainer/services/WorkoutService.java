package com.example.personal_trainer.services;

import com.example.personal_trainer.models.User;
import com.example.personal_trainer.models.Workout;
import com.example.personal_trainer.repositories.UserRepository;
import com.example.personal_trainer.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class WorkoutService {

    @Autowired
    WorkoutRepository workoutRepository;

    @Autowired
    UserRepository userRepository;

    public List<Workout> findAllWorkouts(){return workoutRepository.findAll();}

    public Workout createWorkout(Long userId, String activity, Integer duration, String description){
        Workout newWorkout = new Workout();
        User user = userRepository.findById(userId).get();
        newWorkout.setUser(user);
        newWorkout.setWorkoutDate(LocalDate.now());
        newWorkout.setWorkoutTime(LocalTime.now());
        newWorkout.setActivity(activity);
        newWorkout.setDuration(duration);
        newWorkout.setDescription(description);
        workoutRepository.save(newWorkout);
        return newWorkout;
    }
}
