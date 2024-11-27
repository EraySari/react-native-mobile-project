package com.analysis.project.controller;

import com.analysis.project.config.CustomUserDetails;
import com.analysis.project.model.User;
import com.analysis.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/me")
    public User getCurrentUser(@AuthenticationPrincipal CustomUserDetails currentUser) {
        return userService.validateAndGetUserByTc(currentUser.getUsername());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{username}")
    public User getUser(@PathVariable String username) {
        return userService.validateAndGetUserByTc(username);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{username}")
    public User deleteUser(@PathVariable String username) {
        User user = userService.validateAndGetUserByTc(username);
        userService.deleteUser(user);
        return user;
    }
}