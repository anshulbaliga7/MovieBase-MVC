package com.anshulbaliga.MovieBase.mappers.impl;

import com.anshulbaliga.MovieBase.mappers.Mapper;
import com.anshulbaliga.MovieBase.model.dto.ReviewDto;
import com.anshulbaliga.MovieBase.model.entities.ReviewEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReviewMapperImpl implements Mapper<ReviewEntity, ReviewDto> {
    private ModelMapper modelMapper;

    @Autowired
    public ReviewMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
//        modelMapper.addMappings(new PropertyMap<ReviewEntity, ReviewDto>() {
//            @Override
//            protected void configure() {
//                map().setMovieId(source.getMovie().getId());
//                map().setUserId(source.getUser().getId());
//            }
//
//        });
    }

    @Override
    public ReviewDto mapTo(ReviewEntity entity) {
        return modelMapper.map(entity, ReviewDto.class);
    }

    @Override
    public ReviewEntity mapFrom(ReviewDto dto) {
        return modelMapper.map(dto, ReviewEntity.class);
    }

    @Override
    public List<ReviewDto> mapTo(List<ReviewEntity> entities) {
        return entities.stream().map(this::mapTo).collect(Collectors.toList());
    }

    @Override
    public List<ReviewEntity> mapFrom(List<ReviewDto> dtos) {
        return dtos.stream().map(this::mapFrom).collect(Collectors.toList());
    }
}
