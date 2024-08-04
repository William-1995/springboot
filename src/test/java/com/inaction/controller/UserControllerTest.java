package com.inaction.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inaction.model.User;
import com.inaction.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mvc;
    
    @MockBean
    private UserService userService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void shouldNotGetUserIfUserNotExist() throws Exception {
        when(userService.getUserById(anyList(), anyLong())).thenReturn(Optional.empty());

        mvc.perform(MockMvcRequestBuilders
  			.get("/users/1")
  			.accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().string(""));
    }

    @Test
    void shouldGetUserSuccessIfUseExist() throws Exception {
        when(userService.getUserById(anyList(), anyLong())).thenReturn(Optional.of(new User(1L,"user1")));

        mvc.perform(MockMvcRequestBuilders
  			.get("/users/1")
  			.accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().string("{\"id\":1,\"name\":\"user1\"}"));
    }

    @Test
    void shouldAddUserSuccess() throws Exception {
        mvc.perform(MockMvcRequestBuilders
  			.post("/users/add")
            .content(objectMapper.writeValueAsString(new User(1L,"user1")))
  			.contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().string("{\"id\":1,\"name\":\"user1\"}"));
    }

    @Test
    void shouldDeleteUserSuccess() throws Exception {

        mvc.perform(MockMvcRequestBuilders
  			.post("/users/add")
            .content(objectMapper.writeValueAsString(new User(1L,"user1")))
  			.contentType(MediaType.APPLICATION_JSON));

        mvc.perform(MockMvcRequestBuilders
  			.delete("/users/delete")
            .content(objectMapper.writeValueAsString(new User(1L,"user1")))
  			.contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().string("{\"id\":1,\"name\":\"user1\"}"));
    }
    

    @Test
    void shouldUpdateUserSuccess() throws Exception {
        User updatedUser = new User(1L,"user2");
        when(userService.updateUser(anyList(), any(User.class))).thenReturn(updatedUser);
        mvc.perform(MockMvcRequestBuilders
  			.put("/users/update")
            .content(objectMapper.writeValueAsString(updatedUser))
  			.contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().string("{\"id\":1,\"name\":\"user2\"}"));
    }
}
