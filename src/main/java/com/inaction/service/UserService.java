package com.inaction.service;

import org.springframework.stereotype.Service;
import com.inaction.model.User;
import java.util.*;

/**
 * User service to operate
 */
@Service("userService")
public class UserService {
    
    /**
     * Find user by user ID.
     * @param users A list of {@link User}
     * @param userId The ID of the user.
     * @return Optional {@link User}
     */
    public Optional<User> getUserById(List<User> users, Long userId) {
        if (users.isEmpty()) {
            return Optional.empty();
        }

        return users.stream().filter(user -> user.id().equals(userId)).findFirst();
    }

    /**
     * Update user.
     * @param users A list of {@link User}
     * @param userId The ID of the user.
     * @return Updated {@link User}
     */
    public User updateUser(List<User> users, User user) {
        User updatedUser = user;
        if (users.isEmpty()) {
            return updatedUser;
        }

        for (User it : users) {
            if (it.id().equals(user.id())) {
                updatedUser = new User(user.id(), user.name());
            }
        }
        users.remove(user);
        users.add(updatedUser);
        return updatedUser;
    }
}
