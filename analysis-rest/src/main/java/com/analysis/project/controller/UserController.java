package com.analysis.project.controller;

import com.analysis.project.config.CustomUserDetails;
import com.analysis.project.model.User;
import com.analysis.project.service.BloodAnalysisServiceImpl;
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
    private final BloodAnalysisServiceImpl bloodAnalysisService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/me")
    public User getCurrentUser(@AuthenticationPrincipal CustomUserDetails currentUser) {
        return userService.validateAndGetUserByTc(currentUser.getUsername());
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/updateMe")
    public User updateMe(@AuthenticationPrincipal CustomUserDetails currentUser, @RequestBody User updatedUser) {
        // Kullanıcıyı mevcut kimlik doğrulama bilgilerinden al
        User existingUser = userService.validateAndGetUserByTc(currentUser.getUsername());

        // Mevcut kullanıcı bilgilerini güncelle
        existingUser.setName(updatedUser.getName());
        existingUser.setSurname(updatedUser.getSurname());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setMonth(updatedUser.getMonth());
        existingUser.setGender(updatedUser.getGender());
        // Diğer alanlar için de set metodlarını ekleyebilirsiniz

        // Güncellenmiş kullanıcıyı kaydet
        return userService.saveUser(existingUser);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{tc}")
    public User getUser(@PathVariable String tc) {
        return userService.validateAndGetUserByTc(tc);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{tc}")
    public User deleteUser(@PathVariable String tc) {
        User user = userService.validateAndGetUserByTc(tc);
        userService.deleteUser(user);
        return user;
    }
}