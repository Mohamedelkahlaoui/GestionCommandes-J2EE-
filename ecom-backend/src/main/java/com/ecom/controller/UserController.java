package com.ecom.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.ecom.entity.User;
import com.ecom.service.UserService;
import java.util.List;

import javax.annotation.PostConstruct;
@CrossOrigin("http://localhost:4200")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }

    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "This URL is only accessible to the admin";
    }

    // @GetMapping({"/forUser"})
    // @PreAuthorize("hasRole('User')")
    // public String forUser(){
    //     return "Welcome ";
    // }
     @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('User')")
    public String forUser(){
         Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String username = auth.getName();
    return "Welcome " + username;
    }

    @GetMapping("/allUsers")
@PreAuthorize("hasRole('Admin')")
public List<User> getAllUsers() {
    return userService.getAllUsers();
}
}
