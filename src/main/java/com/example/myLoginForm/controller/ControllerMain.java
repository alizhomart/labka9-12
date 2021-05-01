package com.example.myLoginForm.controller;

import com.example.myLoginForm.model.Role;
import com.example.myLoginForm.model.User;
import com.example.myLoginForm.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;

//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.List;

@org.springframework.stereotype.Controller
public class ControllerMain {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String main(){
        return "home";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }


    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, org.springframework.ui.Model model){
        User userFromDB = userRepository.findByUsername(user.getUsername());

        if(userFromDB != null){
            model.addAttribute("message", "User exists!!!");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);

        return "redirect:/login";
    }
}
