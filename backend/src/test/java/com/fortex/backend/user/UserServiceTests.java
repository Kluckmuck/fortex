package com.fortex.backend;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.when;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fortex.backend.user.UserService;
import com.fortex.backend.user.User;
import com.fortex.backend.user.UserRepository;
import com.fortex.backend.user.UserModel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * UserServiceTests
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

    @MockBean
    public UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testGetUser() throws IOException {
        User user = new User();
        user.setEmail("test@test.se");
        user.setLastName("Karlsson");
        user.setName("Karl");
        user.setPassword("secret!");
        user.setId(1L);
        UserModel model = new UserModel(user);

        when(userService.createUser(model))
        .thenReturn(model);

        UserModel result = userService.createUser(model);
        assertThat(result).isNotNull();
        assertEquals("not same email!", "test@test.se", result.getEmail());
    }
}