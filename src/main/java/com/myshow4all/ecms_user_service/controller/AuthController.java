package com.myshow4all.ecms_user_service.controller;

import com.myshow4all.ecms_user_service.entity.User;
import com.myshow4all.ecms_user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
