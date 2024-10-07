package com.myshow4all.ecms_user_service.repository;

import com.myshow4all.ecms_user_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
