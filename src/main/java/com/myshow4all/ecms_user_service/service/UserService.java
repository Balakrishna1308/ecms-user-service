package com.myshow4all.ecms_user_service.service;

import com.myshow4all.ecms_user_service.entity.User;

import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Optional<User> findByUsername(String username);
}
