package com.springboot.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.demo.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

   // Optional<User> findByUsernameOrEmail(String username, String email);

   // Optional<User> findByUsername(String username);

 //  Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    
    @Query("select u.id from User u where u.email= :email")
    Long findUseridByEmail(String email);
}
