package com.fortex.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;

import com.fortex.backend.security.role.Role;
import com.fortex.backend.user.UserModel;
import com.fortex.backend.user.UserRepository;
import com.fortex.backend.user.UserService;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = true;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        
        if (userRepository.findUserByEmail("user@user.se") == null) {

            UserModel user = new UserModel();
            user.setRoles(new ArrayList<>(Arrays.asList(Role.ROLE_NATIONALMANAGER)));
            user.setEmail("user@user.se");
            user.setPassword("user");
            user.setLastName("test");
            userService.createUser(user);
        }
    }
}