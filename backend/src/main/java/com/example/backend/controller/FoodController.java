package com.example.backend.controller;

import com.example.backend.model.Food;
import com.example.backend.service.Foodservice;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/api")
public class FoodController {
    private final Foodservice foodservice;

    @GetMapping("/food")
    public ResponseEntity<List<Food>> getAllFood() {
        List<Food> foodList = foodservice.getAllFood();
        return new ResponseEntity<>(foodList, HttpStatus.OK);
    }
    @PostMapping("/addfood")
    public ResponseEntity<?>addfood(@RequestBody Food food)
    {
        try{
            Food food1=foodservice.addproduct(food);
            return  new ResponseEntity<>(food1,HttpStatus.CREATED);
        } catch (Exception e) {
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR  );
        }

    }
    @DeleteMapping("/food/{id}")
    public void  deleteuser(@PathVariable int id)
    {
        foodservice.deleteuser(id);
    }
    @PutMapping("/food/{id}")
    public ResponseEntity<?> updateFood(@PathVariable int id, @RequestBody Food foodDetails) {
        try {
            Food updatedFood = foodservice.updateFood(id, foodDetails);
            return new ResponseEntity<>(updatedFood, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }




}
