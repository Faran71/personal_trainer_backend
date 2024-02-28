package com.example.personal_trainer.services;

import com.example.personal_trainer.models.User;
import com.example.personal_trainer.models.UserDTO;
import com.example.personal_trainer.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public List<User> findAllUsers(){return userRepository.findAll();}

    public User addUser(UserDTO userDTO){
        String encryptPassword = passwordEncoder.encode(userDTO.getPassword());

        if(userRepository.findByEmail(userDTO.getEmail())!=null){
            return null;
        }
        User user = new User(userDTO.getName(),userDTO.getEmail(),encryptPassword, userDTO.getWeight(), userDTO.getAgeGroup());
        return this.userRepository.save(user);
    }

    public User checkCredentials(String email, String password){
        // find the user by email
        User user = userRepository.findByEmail(email);
        // Check password matches when encoded
        if (user != null && passwordEncoder.matches(password, user.getPassword())){
            return user;
        }
        // if no user matches then return null
        return null;
    }

    public User changePassword(String email, String password, String newPassword){
        User user = userRepository.findByEmail(email);
        if(user != null && passwordEncoder.matches(password, user.getPassword())){
            String encryptNewPassword = passwordEncoder.encode(newPassword);
            user.setPassword(encryptNewPassword);
            userRepository.save(user);
            return user;
        }
         return null;
    }
}
