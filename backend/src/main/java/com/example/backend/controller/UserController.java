package com.example.backend.controller;


import com.example.backend.model.User;
import com.example.backend.service.Userservice;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/api")
public class UserController {
    private final Userservice userservice;

    @PostMapping("/adduser")
    public ResponseEntity<?> RegisterUser(@RequestBody User user) {
        try {
            User user1 = userservice.RegisterUser(user);
            return new ResponseEntity<>(user1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> LoginUser(@RequestBody User user) {
        try {
            User loggedInUser = userservice.Loginuser(user);
            return new ResponseEntity<>(loggedInUser, HttpStatus.OK); // User object includes userRole
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping("/getuser")
    public ResponseEntity<List<User>> getuser() {
        List<User> foodList = userservice.getuser();
        return new ResponseEntity<>(foodList, HttpStatus.OK);
    }
    @DeleteMapping("/user/{id}")
    public void  deleteuser(@PathVariable int id)
    {
        userservice.deleteuser(id);
    }

}
