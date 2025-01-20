package com.example.backend.service;

import com.example.backend.model.MD5;
import com.example.backend.model.User;
import com.example.backend.repository.Userrepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Userservice {
    private final Userrepository userrepository;

    public User RegisterUser(User user) {
        user.setPassword(MD5.getMd5(user.getPassword()));
        return userrepository.save(user);
    }

    public User Loginuser(User user) throws Exception {
        String hashedPassword = MD5.getMd5(user.getPassword());
        List<User> users = userrepository.findUserbyUsername(user.getUsername());

        if (users.isEmpty()) {
            throw new Exception("Invalid username or password");
        }

        User foundUser = users.get(0);

        if (!foundUser.getPassword().equals(hashedPassword)) {
            throw new Exception("Invalid username or password");
        }

        foundUser.setPassword(null);
        return foundUser;
    }

    public List<User> getuser() {
        return  userrepository.findAll();
    }

    public void deleteuser(int id) {
         userrepository.deleteById(id);
    }
}
