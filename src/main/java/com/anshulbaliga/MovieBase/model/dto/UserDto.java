package com.anshulbaliga.MovieBase.model.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Instant registeredAt;

    @JsonManagedReference(value = "user-review-dto")
    private List<ReviewDto> reviews;
}
