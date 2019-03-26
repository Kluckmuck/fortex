package com.fortex.backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fortex.backend.exceptions.ResourceNotFoundException;
import com.fortex.backend.organization.OrganizationRepository;
import com.fortex.backend.security.JwtTokenProvider;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private JwtTokenProvider jwtTokenProvider;


    @Autowired
    private OrganizationRepository organizationRepository;


    @Autowired
    public UserService(BCryptPasswordEncoder bcCryptPasswordEncoder){
        this.passwordEncoder = bcCryptPasswordEncoder;
    }


    public UserModel createUser(UserModel userModel) {
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setLastName(userModel.getLastName());
        user.setName(userModel.getName());
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        return new UserModel(userRepository.save(user));
    }

    public List<UserModel> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return convertUserListToUserModelList(userList);
    }

    public UserModel getUserById(Long id) {
        User user = userRepository.getOne(id);
        return new UserModel(user);
    }

    /**
     * Användare skapad: 
     * { "id":1, "email": "Betong", "name": "max", "lastName":
     * "jourdnais", "password":"test" }
     * 
     * Login testad med : 
     * { "id":1, "email": "Betonsg", "password":"test" }
     * 
     */
    public String login(String email, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
            return jwtTokenProvider.createToken(email, userRepository.findUserByEmail(email).getRoles());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public ResponseEntity<Void> deleteUserById(Long id) {
        User user = userRepository.getOne(id);
        if (user.getId() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

    public UserModel updateUserById(Long id, UserModel userModel) {
        User user = userRepository.getOne(id);
        user.setEmail(userModel.getEmail());
        user.setLastName(userModel.getLastName());
        user.setName(userModel.getName());
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        return new UserModel(userRepository.save(user));
    }

    public UserModel findUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        return new UserModel(user);
    }



    public List<UserModel> convertUserListToUserModelList(List<User> userList) {
        List<UserModel> userModelList = new ArrayList<>();
        for (User user : userList) {
            userModelList.add(new UserModel(user));
        }
        return userModelList;
    }

    public User addOrganization(Long organizationId, Long userId){
        Optional<User> user = userRepository.findById(userId);
		return organizationRepository.findById(organizationId).map(organization ->{
			user.get().setOrganization(organization);
			return userRepository.save(user.get());
		}).orElseThrow(()-> new ResourceNotFoundException("error0"));
	}

   

}