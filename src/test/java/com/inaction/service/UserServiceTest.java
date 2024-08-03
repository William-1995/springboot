package com.inaction.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.inaction.model.User;
import static org.junit.jupiter.api.Assertions.assertAll;
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
        // Given a list of users and user ID.
        // When run get user action.
        Optional<User> result = userService.getUserById(List.of(new User(1L, "user1")), 1L);

        // Then a user is returned.
        assertEquals(1L, result.get().id());
    }

    @Test
    void shouldUserNotBeUpdatedIfNoUsers() {
        // Given an empty list of users.
        User futureUser = new User(1L, "user");

        // When run update user action.
        User liveUser = userService.updateUser(List.of(), futureUser);

        // Then the user does not be updated.
        assertEquals(liveUser, futureUser);
    }

    @Test
    void shouldUserBeUpdatedIfUserExists() {
        // Given an empty list of users.
        User futureUser = new User(1L, "user3");
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "user1"));
        users.add(new User(2L, "user2"));

        // When run update user action.
        User liveUser = userService.updateUser(users, futureUser);

        // The the use is updated
        assertAll( 
            () -> {assertEquals(liveUser.name(), futureUser.name());}
        );
    }
}
