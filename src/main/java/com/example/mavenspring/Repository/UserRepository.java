package com.example.mavenspring.Repository;

import com.example.mavenspring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(final String email);
}
