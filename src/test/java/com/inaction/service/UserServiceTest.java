package com.inaction.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.inaction.model.User;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

    @Test
    void shouldReturnEmptyIfNoUsers() {
        // Given an empty list of users.
        // When run get user action.
        Optional<User> result = userService.getUserById(List.of(), null);

        // Then a empty user is returned.
        assertEquals(true, result.isEmpty());
    }

    @Test
    void shouldReturnUserIfMatched() {
        // Given an empty list of users.
        // When run get user action.
        Optional<User> result = userService.getUserById(List.of(new User(1L, "user1")), 1L);

        // Then a empty user is returned.
        assertEquals(1L, result.get().id());
    }
}
