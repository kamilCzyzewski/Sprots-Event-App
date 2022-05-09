package com.event.app.sports.service;

import com.event.app.sports.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private static final Logger LOGGER = LogManager.getLogger(RegistrationService.class.getName());
    private final UserRepository userRepository;

    public RegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isPasswordsEqual(String firstPassword, String secondPassword){
        LOGGER.debug("isPasswordsEqual({}, {})", firstPassword, secondPassword);
        boolean isEqual = firstPassword.equals(secondPassword);
        LOGGER.debug("isPasswordsEqual({}, {}) = {}", firstPassword, secondPassword, isEqual);

        return isEqual;
    }
}
