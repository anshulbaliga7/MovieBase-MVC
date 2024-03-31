package com.anshulbaliga.MovieBase.model.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDto {
    private Long id;
    private String review;
    private Double rating;
    private Instant createdAt;
//    private Long MovieId;
//    private Long UserId;

    @JsonBackReference(value = "movie-review-dto")
    private MovieDto movie;

    @JsonBackReference(value = "user-review-dto")
    private UserDto user;
}