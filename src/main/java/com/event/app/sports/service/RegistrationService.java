package com.event.app.sports.service;

import com.event.app.sports.exception.UserException;
import com.event.app.sports.model.UserModel;
import com.event.app.sports.model.dto.RegistrationFormDTO;
import com.event.app.sports.repository.entity.UserEntity;
import com.event.app.sports.service.model.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private static final Logger LOGGER = LogManager.getLogger(RegistrationService.class.getName());
    private final UserService userService;

    public RegistrationService(UserService userService) {
        this.userService = userService;
    }

    public UserModel createUserFromRegistrationForm(RegistrationFormDTO registrationFormDTO, PasswordEncoder passwordEncoder) throws UserException {
        LOGGER.debug("isPasswordsEqual({}, {})", registrationFormDTO, passwordEncoder);
        UserEntity user = new UserEntity();
        user.setUsername(registrationFormDTO.getUsername());
        user.setFirstName(registrationFormDTO.getFirstName());
        user.setSurname(registrationFormDTO.getSurname());
        user.setPassword(passwordEncoder.encode(registrationFormDTO.getPassword()));

        UserModel createdUser = userService.create(user);
        LOGGER.debug("isPasswordsEqual({}, {}) = {}", registrationFormDTO, passwordEncoder, createdUser);

        return createdUser;
    }
}
