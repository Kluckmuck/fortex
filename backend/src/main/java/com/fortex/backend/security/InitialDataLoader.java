package com.fortex.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

import com.fortex.backend.security.role.Role;
import com.fortex.backend.security.role.RoleRepository;
import com.fortex.backend.user.User;
import com.fortex.backend.user.UserRepository;


@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (alreadySetup) {
            return;
        }

        createRoleIfNotFound("ADMIN");
        createRoleIfNotFound("USER");

        Role userRole = roleRepository.findByName("USER");
        Role adminRole = roleRepository.findByName("ADMIN");


        User user = new User();
        user.setPassword(passwordEncoder.encode("test"));
        user.setEmail("user@user.se");
        user.addRoleToUser(userRole);
        userRepository.save(user);


        User user2 = new User();
        user2.setName("Göran");
        user2.setPassword(passwordEncoder.encode("test"));
        user2.setEmail("admin@admin.se");
        user2.addRoleToUser(adminRole);
        userRepository.save(user2);


        User user3 = new User();
        user3.setName("Nisse");
        user3.setPassword(passwordEncoder.encode("user3"));
        user3.setEmail("nisse@user3s.com");
        user3.addRoleToUser(userRole);
        userRepository.save(user3);


        alreadySetup = true;
    }

    private Role createRoleIfNotFound(String name) {
        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role();
            role.setName(name);
            roleRepository.save(role);
        }
        return role;
    }


}
