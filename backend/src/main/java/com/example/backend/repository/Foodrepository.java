package com.example.backend.repository;

import com.example.backend.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Foodrepository extends JpaRepository<Food, Integer> {
}
