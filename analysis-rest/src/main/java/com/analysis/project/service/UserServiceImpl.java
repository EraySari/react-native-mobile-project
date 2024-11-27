package com.analysis.project.service;

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
        return Optional.ofNullable(userRepository.findByTc(tc).orElseThrow(() -> new RuntimeException(tc)));
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
                .orElseThrow(() -> new RuntimeException(tc));
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        if (!hasUserWithTc(user.getTc())) {
            throw new RuntimeException(user.getTc());
        }
        userRepository.delete(user);
    }

    @Override
    public Optional<User> validTcAndPassword(String tc, String password) {
        return getUserByTc(tc)
                .filter(user -> passwordEncoder.matches(password, user.getPassword()));

    }
}
