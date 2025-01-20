package com.example.backend.service;

import com.example.backend.model.Food;
import com.example.backend.repository.Foodrepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class Foodservice {
    private final Foodrepository foodrepository;

    public List<Food> getAllFood() {
        return foodrepository.findAll();
    }

    public Food addproduct(Food food) {
        return foodrepository.save(food);

    }

    public void deleteuser(int id) {
        foodrepository.deleteById(id);
    }
    public Food updateFood(int id, Food foodDetails) {
        return foodrepository.findById(id).map(existingFood -> {
            existingFood.setName(foodDetails.getName());
            existingFood.setPrice(foodDetails.getPrice());
            existingFood.setDescription(foodDetails.getDescription());
            existingFood.setStatus(foodDetails.getStatus());
            return foodrepository.save(existingFood);
        }).orElseThrow(() -> new RuntimeException("Food item not found with id: " + id));
    }

}
