package com.example.personal_trainer.components;

import com.example.personal_trainer.models.User;
import com.example.personal_trainer.repositories.UserRepository;
import com.example.personal_trainer.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    WorkoutRepository workoutRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public void run(ApplicationArguments args) throws Exception{

        String encryptPassword = passwordEncoder.encode("12345");
        User user = new User("Steve","@gmail",encryptPassword, 60, "18-40");
        userRepository.save(user);
    }
}









