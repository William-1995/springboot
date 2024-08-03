package com.inaction.service;

import org.springframework.stereotype.Service;
import com.inaction.model.User;
import java.util.*;

/**
 * User service to 
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

        return users.stream().filter(user -> user.getId().equals(userId)).findFirst();
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
            if (it.getId().equals(user.getId())) {
                it.setName(user.getName());
                updatedUser = it;
            }
        }

        return updatedUser;
    }

}
