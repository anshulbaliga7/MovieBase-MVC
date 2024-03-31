package com.anshulbaliga.MovieBase.service;

import com.anshulbaliga.MovieBase.model.dto.UserDto;
import com.anshulbaliga.MovieBase.model.entities.ReviewEntity;
import com.anshulbaliga.MovieBase.model.entities.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserEntity registerUser(UserEntity userEntity);
    Optional<UserEntity> getUserById(Long id);

    List<ReviewEntity> findReviewsByUserId(Long userId);

    void deleteUser(Long id);

    UserEntity updateUser(UserEntity userEntity);

    List<UserEntity> getAllUsers();

    Optional<UserEntity> loginUser(String email, String password);
}
