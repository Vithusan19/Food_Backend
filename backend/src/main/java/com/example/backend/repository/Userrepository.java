package com.example.backend.repository;

import com.example.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Userrepository extends JpaRepository<User,Integer> {
    List<User> findByusername(String username);

    @Query(value = "SELECT * FROM user  WHERE username=:username", nativeQuery = true)
    List<User> findUserbyUsername(String username);
}
