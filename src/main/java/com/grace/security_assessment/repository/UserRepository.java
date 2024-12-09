package com.grace.security_assessment.repository;

import com.grace.security_assessment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    List<User> findByUsernameUnsafe(String username);
}