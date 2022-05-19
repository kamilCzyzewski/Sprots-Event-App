package com.event.app.sports.controller;

import com.event.app.sports.exception.UserException;
import com.event.app.sports.model.dto.RegistrationFormDTO;
import com.event.app.sports.service.RegistrationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String registrationView(Model model) {
        LOGGER.info("registrationView()");
        model.addAttribute("registrationFormDTO", new RegistrationFormDTO());
        LOGGER.info("registrationView()");

        return "registration";
    }

    @PostMapping
    public String createUser(@Valid RegistrationFormDTO registrationFormDTO, Errors errors) throws UserException {
        LOGGER.info("createUser({})", registrationFormDTO);
        if (errors.hasErrors()) {
            return "registration";
        }

        registrationService.createUserFromRegistrationForm(registrationFormDTO);
        LOGGER.info("createUser({})", registrationFormDTO);

        return "redirect:/login";
    }
}
