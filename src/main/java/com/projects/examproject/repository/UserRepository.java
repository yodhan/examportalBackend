package com.projects.examproject.repository;

import com.projects.examproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    public User findByUserName(String username);
}
