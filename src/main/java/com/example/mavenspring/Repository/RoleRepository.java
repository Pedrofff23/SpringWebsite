package com.example.mavenspring.Repository;


import com.example.mavenspring.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(final String role);
}