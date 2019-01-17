package com.fortex.backend;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.ArrayList;
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
 * Unit tests
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
        //Create mock user
        User user = new User();
        user.setEmail("test@test.se");
        user.setLastName("Karlsson");
        user.setName("Karl");
        user.setPassword("secret!");
        user.setId(1L);
        UserModel model = new UserModel(user);

        //Define what will be returned when calling createUser in the service
        when(userService.createUser(model)).thenReturn(model);

        UserModel result = userService.createUser(model);
        assertThat(result).isNotNull();
        assertEquals("not same email!", "test@test.se", result.getEmail());
    }

    @Test
    public void getAllUsers() throws IOException {
        User user1 = new User();
        user1.setEmail("user1@gmail.com");
        UserModel model1 = new UserModel(user1);
        User user2 = new User();
        user2.setEmail("user2@gmail.com");
        UserModel model2 = new UserModel(user2);

        List<UserModel> userList = new ArrayList<UserModel>();
        userList.add(model1);
        userList.add(model2);
        when(userService.getAllUsers()).thenReturn(userList);
        List<UserModel> result = userService.getAllUsers();
        assertThat(result).isNotNull()
            .isNotEmpty()
            .allMatch(x -> x.getEmail()
            .contains("gmail.com"));
        assertThat(result.get(0).getEmail()).contains("user1@gmail.com");
        assertThat(result.get(1).getEmail()).contains("user2@gmail.com");
    }

    @Test
    public void deleteUserByIdNotFound() throws IOException {
        when(userService.deleteUserById(1L))
        .thenReturn(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        ResponseEntity result = userService.deleteUserById(1L);
        assertThat(result).isNotNull();
        assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    public void deleteUserByIdFound() throws IOException {
        when(userService.deleteUserById(1L)).thenReturn(new ResponseEntity<>(HttpStatus.OK));
        ResponseEntity result = userService.deleteUserById(1L);
        assertThat(result).isNotNull();
        assertEquals(result.getStatusCode(), HttpStatus.OK);
    }
}