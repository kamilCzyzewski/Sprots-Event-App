package com.event.app.sports.service.model;

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

    public UserModel create(UserEntity user){
        LOGGER.debug("create({})", user);
        UserEntity created = userRepository.save(user);
        //TODO: rzucać wyjątek usera jak powstanie
        UserModel createdModel = userMapper.toSource(created).orElseThrow();
        LOGGER.debug("create({}) = {}", user, createdModel);

        return createdModel;
    }

    public UserModel readById(Long id){
        LOGGER.debug("readById({})", id);
        UserModel readUser = userMapper
                .toSource(userRepository.getById(id))
                //TODO: rzucić wyjątek
                .orElseThrow();
        LOGGER.debug("readById({}) = {}", id, readUser);

        return readUser;
    }

    public UserModel readByUsername(String username){
        LOGGER.debug("readByUsername({})", username);
        UserModel readUser = userMapper
                .toSource(userRepository.findOneByUsername(username))
                //TODO: rzucić wyjątek
                .orElseThrow();
        LOGGER.debug("readByUsername({}) = {}", username, readUser);

        return readUser;
    }
}
