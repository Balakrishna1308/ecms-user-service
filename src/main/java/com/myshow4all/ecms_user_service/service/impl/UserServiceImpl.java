package com.myshow4all.ecms_user_service.service.impl;
import com.myshow4all.ecms_user_service.entity.User;
import com.myshow4all.ecms_user_service.repository.UserRepository;
import com.myshow4all.ecms_user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
