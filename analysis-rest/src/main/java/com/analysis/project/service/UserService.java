package com.analysis.project.service;

import com.analysis.project.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getUsers();

    Optional<User> getUserByTc(String tc);

    boolean hasUserWithTc(String tc);

    boolean hasUserWithEmail(String email);

    User validateAndGetUserByTc(String tc);

    User saveUser(User user);

    void deleteUser(User user);

    Optional<User> validTcAndPassword(String tc, String password);
}
