package com.igorgorbachev.SpringMVCAndHibernateAndSpringBoot.controller;

import com.igorgorbachev.SpringMVCAndHibernateAndSpringBoot.model.User;
import com.igorgorbachev.SpringMVCAndHibernateAndSpringBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("listUsers", users);
        return "user";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user, Model model) {
        try {
            userService.addUser(user);
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "user";
        }
        return "redirect:/";
    }

    @PostMapping("/changeUser")
    public String changeUser(@ModelAttribute("user") User user) {
        userService.changeUser(user);
        return "redirect:/";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@ModelAttribute("user") User user) {
        userService.deleteUser(user);
        return "redirect:/";
    }


}
