package com.example.personal_trainer.controllers;

import com.example.personal_trainer.authentication.LogInForm;
import com.example.personal_trainer.models.ChangePasswordDTO;
import com.example.personal_trainer.models.User;
import com.example.personal_trainer.models.UserDTO;
import com.example.personal_trainer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/users"})
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){ return ResponseEntity.ok(userService.findAllUsers());}

    @PostMapping
    public ResponseEntity<User> postUser(@RequestBody UserDTO userDTO){
        User addUser = userService.addUser(userDTO);
//        return new ResponseEntity<>(addUser,HttpStatus.CREATED);
        return addUser != null ? new ResponseEntity<>(addUser, HttpStatus.ACCEPTED) : new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<User> authenticateUser(@RequestBody LogInForm logInForm){
        User checkUser = userService.checkCredentials(logInForm.getEmail(), logInForm.getPassword());
        return checkUser != null ? new ResponseEntity<>(checkUser,HttpStatus.ACCEPTED) : new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        return new ResponseEntity<>(checkUser, HttpStatus.OK);
    }

    @PutMapping("/changePassword")
    public ResponseEntity<User> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO){
        User newPasswordUser = userService.changePassword(changePasswordDTO.getEmail(), changePasswordDTO.getPassword(), changePasswordDTO.getNewPassword());
        return newPasswordUser != null ? new ResponseEntity<>(newPasswordUser,HttpStatus.ACCEPTED) : new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
