package com.event.app.sports.service;

import com.event.app.sports.repository.UserRepository;
import com.event.app.sports.repository.entity.UserEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoggingUserDetailsService implements UserDetailsService {

    private static final Logger LOGGER = LogManager.getLogger(LoggingUserDetailsService.class.getName());
    private final UserRepository userRepository;

    public LoggingUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.debug("loadUserByUsername({})", username);
        UserEntity user = userRepository.findOneByUsername(username);
        if (user != null) {
            LOGGER.debug("loadUserByUsername({}) = {}", username, user);
            return user;
        }
        LOGGER.debug("loadUserByUsername({}) = {}", username, "not found");
        throw new UsernameNotFoundException(
                "Użytkownik '" + username + "' nie znaleziony");
    }
}
