package com.inaction.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
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
 * A restful controller to operate users.
 */
@RestController
@RequestMapping("users")
public class UserController {

    // region - constant filed.
    private static final List<User> users = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    // region - service
    private final UserService userService;

    // region - constructor
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // region - public methods
    @GetMapping("/{id}")
    public User get(@PathVariable("id") @NonNull Long id) {
        logger.info("Receive get user request, the user ID is [{}]", id);
        Optional<User> user = userService.getUserById(users, id);
        return user.orElse(null);
    }

    @PostMapping("/add")
    public User add(@RequestBody User user) {
        users.add(user);
        return user;
    }

    @DeleteMapping("/delete")
    public User delete(@RequestBody User user) {
        users.removeIf(it -> it.id().equals(user.id()));
        return user;
    }

    @PutMapping("/update")
    public User update(@RequestBody User user) {
        return userService.updateUser(users, user);
    }

    // region - private methods
}
