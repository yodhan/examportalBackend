package com.projects.examproject.service;

import com.projects.examproject.entity.User;
import com.projects.examproject.entity.UserRoles;

import java.util.Set;

public interface UserService {

    public User createUser(User user, Set<UserRoles> userRoles);
    public User getUser(String userName);
    public void deleteUser(Long userId);
}
