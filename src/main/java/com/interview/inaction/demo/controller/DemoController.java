package com.interview.inaction.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.interview.inaction.demo.model.User;

@RestController
@RequestMapping("users")
public class DemoController {

    
    @GetMapping("/{id}")
    public int get(@PathVariable("id") int id) {
        return id;
    }

    @PostMapping("/add")
    public User add(@RequestBody User user) {
        return user;
    }
}
