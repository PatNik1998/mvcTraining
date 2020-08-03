package ru.patnik.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.patnik.dao.UserDao;
import ru.patnik.entity.User;

@Controller
public class UserController {
    private UserDao userDao;

    @Autowired
    public UserController(UserDao userDao){
        this.userDao = userDao;
    }

    @GetMapping("/register")
    public String addUserPage(){
        return  "registrationPage";
    }

  @PostMapping("/register")
    public String registerUser(@ModelAttribute User user){
       userDao.addUser(user);
       return "lk";
    }
}
