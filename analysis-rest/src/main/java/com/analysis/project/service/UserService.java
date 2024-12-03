package com.analysis.project.service;

import com.analysis.project.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getUsers();

    Optional<User> getUserByTc(String tc);

    Optional<User> getUserByNameAndSurname(String name,String surname);

    boolean hasUserWithTc(String tc);

    boolean hasUserWithEmail(String email);

    User validateAndGetUserByTc(String tc);

    User validateAndGetUserByNameAndSurname(String name, String surname);

    User saveUser(User user);

    void deleteUser(User user);

    Optional<User> validTcAndPassword(String tc, String password);
}
