package com.example.restcontrollers;

import com.example.models.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRestControllers {

    @PostMapping("/register")
    public User register( @RequestBody User user ) {
        user.setUid(100);
        return user;
    }

    @GetMapping("/users/{uid}")
    public User getUser(@PathVariable int uid) {
        User u = new User();
        u.setEmail("ali@mail.com");
        u.setPassword("12345");
        return u;
    }

}
