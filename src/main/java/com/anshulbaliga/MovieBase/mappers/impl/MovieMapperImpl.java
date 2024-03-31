package com.anshulbaliga.MovieBase.mappers.impl;

import com.anshulbaliga.MovieBase.mappers.Mapper;
import com.anshulbaliga.MovieBase.model.dto.MovieDto;
import com.anshulbaliga.MovieBase.model.entities.MovieEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieMapperImpl implements Mapper<MovieEntity, MovieDto> {
    private ModelMapper modelMapper;

    @Autowired
    public MovieMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public MovieDto mapTo(MovieEntity entity) {
        return modelMapper.map(entity, MovieDto.class);
    }

    @Override
    public MovieEntity mapFrom(MovieDto dto) {
        return modelMapper.map(dto, MovieEntity.class);
    }

    @Override
    public List<MovieDto> mapTo(List<MovieEntity> entities) {
        return entities.stream().map(this::mapTo).collect(Collectors.toList());
    }

    @Override
    public List<MovieEntity> mapFrom(List<MovieDto> dtos) {
        return dtos.stream().map(this::mapFrom).collect(Collectors.toList());
    }
}
