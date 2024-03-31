package com.anshulbaliga.MovieBase.service.impl;

import com.anshulbaliga.MovieBase.model.entities.ReviewEntity;
import com.anshulbaliga.MovieBase.model.entities.UserEntity;
import com.anshulbaliga.MovieBase.repository.ReviewRepository;
import com.anshulbaliga.MovieBase.repository.UserRepository;
import com.anshulbaliga.MovieBase.service.ReviewService;
import com.anshulbaliga.MovieBase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ReviewService reviewService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity registerUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<ReviewEntity> findReviewsByUserId(Long userId) {
        return reviewService.findReviewsByUserId(userId);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserEntity updateUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> loginUser(String email, String password) {
        return userRepository.findUserByEmailAndPassword(email, password);
    }
}
