package com.projects.examproject.controller;

import com.projects.examproject.CorsConfig;
import com.projects.examproject.config.JwtUtil;
import com.projects.examproject.entity.JwtRequest;
import com.projects.examproject.entity.JwtRespone;
import com.projects.examproject.entity.User;
import com.projects.examproject.service.userimplementation.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin
@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Autowired
    private JwtUtil jwtUtils;


    //token generation
    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try{
            authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());

        }catch (UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("User not found");
        }
        UserDetails userDetails =this.userDetailService.loadUserByUsername(jwtRequest.getUsername());
        String token =this.jwtUtils.generateToken(userDetails);

        return  ResponseEntity.ok(new JwtRespone(token));
  }


    private void authenticate(String username, String password) throws Exception {

        try{

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));

        }catch (DisabledException e){
            throw new Exception("USER DISABLED" +e.getMessage());
        }catch (BadCredentialsException e){
            throw new Exception("Invalid Credentials" +e.getMessage());
        }
    }

    @GetMapping("/current-user")
    public User getcurrentUser(Principal principal){
        return (User)this.userDetailService.loadUserByUsername(principal.getName());
    }

}
