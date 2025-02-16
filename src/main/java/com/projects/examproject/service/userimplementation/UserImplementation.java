package com.projects.examproject.service.userimplementation;

import com.projects.examproject.entity.User;
import com.projects.examproject.entity.UserRoles;
import com.projects.examproject.repository.UserRepository;
import com.projects.examproject.repository.UserRoleRepository;
import com.projects.examproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;


    @Override
    public User createUser(User user, Set<UserRoles> userRoles) {
        User local = this.userRepository.findByUserName(user.getUserName());
        if (local!=null)
        {
            System.out.println("UserAlready exists");
        }
        else {
            for (UserRoles userRole:userRoles){
                userRoleRepository.save(userRole.getRole());
            }
            user.getUserRoles().addAll(userRoles);
           local= this.userRepository.save(user);
        }
        return local;
    }

    @Override
    public User getUser(String userName) {
        return this.userRepository.findByUserName(userName);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }

}
