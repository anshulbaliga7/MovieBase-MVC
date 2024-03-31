package com.anshulbaliga.MovieBase.config;

import com.anshulbaliga.MovieBase.model.dto.ReviewDto;
import com.anshulbaliga.MovieBase.model.entities.ReviewEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

//        TypeMap<ReviewEntity, ReviewDto> typeMap = modelMapper.createTypeMap(ReviewEntity.class, ReviewDto.class);
//        typeMap.addMapping(src -> src.getMovie().getId(), ReviewDto::setMovieId);
//        typeMap.addMapping(src -> src.getUser().getId(), ReviewDto::setUserId);
        return modelMapper;
    }
}
