package com.event.app.sports.service.mapper;

import com.event.app.sports.model.UserModel;
import com.event.app.sports.repository.entity.UserEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserMapper implements MapperInt<UserModel, UserEntity> {

    private static final Logger LOGGER = LogManager.getLogger(UserMapper.class.getName());

    @Override
    public Optional<UserModel> toSource(UserEntity target) {
        LOGGER.info("toSource({})", target);
        Optional<UserModel> mappedModel;
        if (target == null)
            mappedModel = Optional.empty();
        else {
            ModelMapper modelMapper = new ModelMapper();
            UserModel model = modelMapper.map(target, UserModel.class);
            mappedModel = Optional.of(model);
        }
        LOGGER.info("toSource({}) = {}", target, mappedModel);
        return mappedModel;
    }

    @Override
    public Optional<UserEntity> toTarget(UserModel source) {
        LOGGER.info("toTarget({})", source);
        Optional<UserEntity> mappedEntity;
        if (source == null)
            mappedEntity = Optional.empty();
        else {
            ModelMapper modelMapper = new ModelMapper();
            UserEntity entity = modelMapper.map(source, UserEntity.class);
            mappedEntity = Optional.of(entity);
        }
        LOGGER.info("toTarget({}) = {}", source, mappedEntity);
        return mappedEntity;
    }
}
