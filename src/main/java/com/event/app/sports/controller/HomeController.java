package com.event.app.sports.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping
public class HomeController {

    private static final Logger LOGGER = LogManager.getLogger(HomeController.class.getName());

    @GetMapping("/")
    public String dashboard(Principal principal, Model model) {
        if (principal != null) {
            model.addAttribute("username", principal.getName());
        } else {
            model.addAttribute("username", "brak");
        }

        return "dashboard";
    }
}
