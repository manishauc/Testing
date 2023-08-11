package com.springboot.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
