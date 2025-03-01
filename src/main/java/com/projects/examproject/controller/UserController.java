package com.projects.examproject.controller;

import com.projects.examproject.entity.Role;
import com.projects.examproject.entity.User;
import com.projects.examproject.entity.UserRoles;
import com.projects.examproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
//@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/create-user")
    public User createUser(@RequestBody User user){
        Set<UserRoles> roles = new HashSet<>();
        Role role= new Role();
        role.setRoleId(45L);
        role.setRoleName("NORMAL");

        //
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

        UserRoles userRoles= new UserRoles();
        userRoles.setRole(role);
        userRoles.setUser(user);
        roles.add(userRoles);

        return this.userService.createUser(user,roles);
    }

    @GetMapping("/{username}")
    public User getUserName(@PathVariable String username){
        return this.userService.getUser(username);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        this.userService.deleteUser(userId);
    }

}
