package com.analysis.project.repository;

import com.analysis.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByTc(String tc);

    Optional<User> findByNameAndSurname(String name, String surname);

    boolean existsByTc(String tc);

    boolean existsByEmail(String email);
}
