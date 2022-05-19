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
    private final PasswordEncoder passwordEncoder;

    public RegistrationService(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    public UserModel createUserFromRegistrationForm(RegistrationFormDTO registrationFormDTO) throws UserException {
        LOGGER.info("isPasswordsEqual({}, {})", registrationFormDTO, passwordEncoder);
        UserEntity user = registrationFormDTO.toUserEntity(passwordEncoder);
        UserModel createdUser = userService.create(user);
        LOGGER.info("isPasswordsEqual({}, {}) = {}", registrationFormDTO, passwordEncoder, createdUser);

        return createdUser;
    }
}
