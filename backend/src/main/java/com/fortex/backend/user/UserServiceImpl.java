package com.fortex.backend.user;

import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserServiceImpl {

//    private final UserRepository userRepository;
//
//    @Autowired
//    public UserServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    //TODO refaktorera user eller fixa user i spring details. Kanske går att överskrida.
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
//        Uzer loginUser = userRepository.findUserByEmail(email);
//
//
//        return new User(loginUser.getEmail(), loginUser.getPassword(),emptyList());
//    }
}
