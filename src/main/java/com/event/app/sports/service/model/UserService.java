package com.event.app.sports.service.model;

import com.event.app.sports.exception.UserException;
import com.event.app.sports.model.UserModel;
import com.event.app.sports.repository.UserRepository;
import com.event.app.sports.repository.entity.UserEntity;
import com.event.app.sports.service.mapper.UserMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger LOGGER = LogManager.getLogger(UserService.class.getName());
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserModel create(UserEntity user) throws UserException {
        LOGGER.debug("create({})", user);
        UserEntity created = userRepository.save(user);
        UserModel createdModel = userMapper.toSource(created)
                .orElseThrow(() -> new UserException("Nie udało się stworzyć użytkownika"));
        LOGGER.debug("create({}) = {}", user, createdModel);

        return createdModel;
    }

    public UserModel readById(Long id) throws UserException {
        LOGGER.debug("readById({})", id);
        UserModel readUser = userMapper
                .toSource(userRepository.getById(id))
                .orElseThrow(() -> new UserException("Nie znaleziono użytkownika"));
        LOGGER.debug("readById({}) = {}", id, readUser);

        return readUser;
    }

    public UserModel readByUsername(String username) throws UserException {
        LOGGER.debug("readByUsername({})", username);
        UserModel readUser = userMapper
                .toSource(userRepository.findOneByUsername(username))
                .orElseThrow(() -> new UserException("Nie znaleziono użytkownika"));
        LOGGER.debug("readByUsername({}) = {}", username, readUser);

        return readUser;
    }
}
