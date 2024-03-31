package com.anshulbaliga.MovieBase.controller;

import com.anshulbaliga.MovieBase.mappers.Mapper;
import com.anshulbaliga.MovieBase.model.dto.UserDto;
import com.anshulbaliga.MovieBase.model.entities.UserEntity;
import com.anshulbaliga.MovieBase.service.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@Log
public class UserController {
    private UserService userService;
    private Mapper<UserEntity, UserDto> userMapper;

    @Autowired
    public UserController(UserService userService, Mapper<UserEntity, UserDto> userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto user) {
        log.info("Registering user" + user);
        UserEntity userEntity = userMapper.mapFrom(user);
        UserEntity savedUser = userService.registerUser(userEntity);

        return ResponseEntity.ok(userMapper.mapTo(savedUser));
        // sample json
        // {
        //     "id": 1,
        //     "username": "user",
        //     "password": "password",
        //     "email": "
        // }
    }

    @GetMapping("/login")
    public ResponseEntity<UserDto> loginUser(@RequestParam("email") String email, @RequestParam("password") String password) {
        log.info("Logging in user");
        Optional<UserEntity> user = userService.loginUser(email, password);
        return user.map(userEntity -> ResponseEntity.ok(userMapper.mapTo(userEntity))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        log.info("Deleting user");
        Optional<UserEntity> user = userService.getUserById(id);

        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        userService.deleteUser(id);
        return ResponseEntity.ok("User Id: " + id + " deleted");
    }

    @GetMapping("/admin/all")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        log.info("Getting all users");
        return ResponseEntity.ok(userMapper.mapTo(userService.getAllUsers()));
    }
}
