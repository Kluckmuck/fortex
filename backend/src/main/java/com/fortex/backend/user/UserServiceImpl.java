package com.fortex.backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import static java.util.Collections.emptyList;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.fortex.backend.security.role.Role;

@Service
public class UserServiceImpl implements UserDetailsService{

   private UserRepository userRepository;

   @Autowired
   public UserServiceImpl(UserRepository userRepository) {
       this.userRepository = userRepository;
   }

   //TODO refaktorera user eller fixa user i spring details. Kanske går att överskrida.
   @Override
   public UserDetails loadUserByUsername(String email){
       Optional<User> user = userRepository.findUserByEmail(email);
       Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
       for (Role role : user.get().getRoles()){
           grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
       }
       return new org.springframework.security.core.userdetails.User(user.get().getEmail(),user.get().getPassword(), grantedAuthorities);
   }
}
