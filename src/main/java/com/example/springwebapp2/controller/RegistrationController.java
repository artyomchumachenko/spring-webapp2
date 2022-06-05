package com.example.springwebapp2.controller;

import com.example.springwebapp2.domain.UserEntity;
import com.example.springwebapp2.repos.UserRepo;
import com.example.springwebapp2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(

    ) {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(
            UserEntity user,
            Map<String, Object> model
    ) {
        return userService.addUser(user, model);
    }
}
