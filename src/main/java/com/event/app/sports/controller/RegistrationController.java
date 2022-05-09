package com.event.app.sports.controller;

import com.event.app.sports.model.dto.RegistrationFormDTO;
import com.event.app.sports.service.RegistrationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private static final Logger LOGGER = LogManager.getLogger(RegistrationController.class.getName());
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String registrationView(Model model){
        LOGGER.debug("registrationView()");
        model.addAttribute("registrationFormDTO", new RegistrationFormDTO());

        //TODO: zwrócić widok jak już powstanie
        LOGGER.debug("registrationView()");

        return null;
    }
}
