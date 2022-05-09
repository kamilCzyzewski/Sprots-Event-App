package com.event.app.sports.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AccessDeniedController {
    private static final Logger LOGGER = LogManager.getLogger(AccessDeniedController.class.getName());

    @GetMapping("/access-denied")
    public String getAccessDenied() {
        LOGGER.info("getAccessDenied()");
        LOGGER.info("getAccessDenied()");
        return "access-denied";
    }
}
