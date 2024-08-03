package com.inaction.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.inaction.model.User;
import com.inaction.service.UserService;
import java.util.*;

/**
 * A resuful controller to operate users.
 */
@RestController
@RequestMapping("users")
public class UserController {

    // region - constant fileds.
    private static final List<User> users = new ArrayList<>();

    // region - service
    private final UserService userService;

    // region - constructor
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // region - public methods
    @GetMapping("/{id}")
    public User get(@PathVariable("id") Long id) {
        return userService.getUserById(users, id).get();
    }

    @PostMapping("/add")
    public User add(@RequestBody User user) {
        users.add(user);
        return user;
    }

    @DeleteMapping("/delete")
    public User delete(@RequestBody User user) {
        users.removeIf(it -> it.getId().equals(user.getId()));
        return user;
    }

    @PutMapping("/update")
    public User update(@RequestBody User user) {
        return userService.updateUser(users, user);
    }

    // region - private methods
}
