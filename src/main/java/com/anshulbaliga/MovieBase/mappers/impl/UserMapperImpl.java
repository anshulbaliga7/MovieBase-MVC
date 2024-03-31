package com.anshulbaliga.MovieBase.mappers.impl;

import com.anshulbaliga.MovieBase.mappers.Mapper;
import com.anshulbaliga.MovieBase.model.dto.UserDto;
import com.anshulbaliga.MovieBase.model.entities.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapperImpl implements Mapper<UserEntity, UserDto> {
    private ModelMapper modelMapper;

    @Autowired
    public UserMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto mapTo(UserEntity entity) {
        return modelMapper.map(entity, UserDto.class);
    }

    @Override
    public UserEntity mapFrom(UserDto dto) {
        return modelMapper.map(dto, UserEntity.class);
    }

    @Override
    public List<UserDto> mapTo(List<UserEntity> entities) {
        return entities.stream().map(this::mapTo).collect(Collectors.toList());
    }

    @Override
    public List<UserEntity> mapFrom(List<UserDto> dtos) {
        return dtos.stream().map(this::mapFrom).collect(Collectors.toList());
    }
}
