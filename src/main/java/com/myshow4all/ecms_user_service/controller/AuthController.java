package com.myshow4all.ecms_user_service.controller;

import com.myshow4all.ecms_user_service.entity.User;
import com.myshow4all.ecms_user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user)
    {
        User registeredUser = userService.saveUser(user);
        return ResponseEntity.ok(registeredUser);
    }




    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User loginRequest)
    {
        Optional<User> existingUser = userService.findByUsername(loginRequest.getUsername());

        if (existingUser.isPresent())
        {
            User user = existingUser.get();

            if (user.getPassword().equals(loginRequest.getPassword()))
            {
                return ResponseEntity.ok("Login successful");
            }
            else
            {
                return ResponseEntity.status(401).body("Invalid password");
            }

        }

        else
        {
            return ResponseEntity.status(404).body("User not found");
        }
    }




}
