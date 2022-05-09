package com.event.app.sports.controller;

import com.event.app.sports.exception.UserException;
import com.event.app.sports.model.dto.RegistrationFormDTO;
import com.event.app.sports.service.RegistrationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private static final Logger LOGGER = LogManager.getLogger(RegistrationController.class.getName());
    private final RegistrationService registrationService;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(RegistrationService registrationService, PasswordEncoder passwordEncoder) {
        this.registrationService = registrationService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registrationView(Model model){
        LOGGER.info("registrationView()");
        model.addAttribute("registrationFormDTO", new RegistrationFormDTO());
        LOGGER.info("registrationView()");

        return "registration";
    }

    @PostMapping
    public String createUser(@Valid RegistrationFormDTO registrationFormDTO, Errors errors) throws UserException {
        LOGGER.info("createUser({})", registrationFormDTO);
        if(errors.hasErrors()){
            return "registration";
        }

        registrationService.createUserFromRegistrationForm(registrationFormDTO, passwordEncoder);
        LOGGER.info("createUser({})", registrationFormDTO);

        return "redirect:/login";
    }
}
