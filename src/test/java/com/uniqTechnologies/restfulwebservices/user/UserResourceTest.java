package com.uniqTechnologies.restfulwebservices.user;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserDaoService userDaoService;

    @InjectMocks
    private UserResource userResource;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRetrieveAllUsers() throws Exception {
        List<User> userList = Arrays.asList(new User(1, "Adam", new Date()), new User(2, "Eve", new Date()),
                new User(3, "Jack", new Date()));
        Mockito.when(userDaoService.findAll()).thenReturn(userList);

        mockMvc.perform(MockMvcRequestBuilders.get("/users").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Adam"))
                .andExpect(jsonPath("$[1].name").value("Eve"))
                .andExpect(jsonPath("$[2].name").value("Jack"));
    }

    @Test
    public void testRetrieveUser() throws Exception {
        User user = new User(1, "John", new Date());
        Mockito.when(userDaoService.findOne(1)).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.get("/users/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Adam"));
    }

    // You can write similar tests for other methods like createUser, deleteUser,
    // and retrieveUser_hateoas.
}

