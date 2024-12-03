package com.analysis.project.service;

import com.analysis.project.handler.NameAndSurnameNotFoundException;
import com.analysis.project.handler.PermissionLoginException;
import com.analysis.project.handler.UserNotFoundException;
import com.analysis.project.model.User;
import com.analysis.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserByTc(String tc) {
        return Optional.ofNullable(userRepository.findByTc(tc).orElseThrow(() -> new UserNotFoundException(tc)));
    }

    @Override
    public Optional<User> getUserByNameAndSurname(String name,String surname) {
        return Optional.ofNullable(userRepository.findByNameAndSurname(name,surname).orElseThrow(() -> new NameAndSurnameNotFoundException(name+" "+surname +" Not Found")));
    }

    @Override
    public boolean hasUserWithTc(String tc) {
        return userRepository.existsByTc(tc);
    }

    @Override
    public boolean hasUserWithEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User validateAndGetUserByTc(String tc) {
        return getUserByTc(tc)
                .orElseThrow(() -> new UserNotFoundException(tc));
    }

    @Override
    public User validateAndGetUserByNameAndSurname(String name, String surname) {
        return getUserByNameAndSurname(name,surname).orElseThrow(() -> new NameAndSurnameNotFoundException(name+" "+surname+" not found"));
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        if (!hasUserWithTc(user.getTc())) {
            throw new UserNotFoundException(user.getTc());
        }
        userRepository.delete(user);
    }

    @Override
    public Optional<User> validTcAndPassword(String tc, String password) {
        return Optional.ofNullable(getUserByTc(tc)
                .filter(user -> passwordEncoder.matches(password, user.getPassword())).orElseThrow(() -> new PermissionLoginException("Tc or Password Wrong")));

    }
}
