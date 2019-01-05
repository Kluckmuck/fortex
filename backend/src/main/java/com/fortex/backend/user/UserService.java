package com.fortex.backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserModel createUser(UserModel userModel) {
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setLastName(userModel.getLastName());
        user.setName(userModel.getName());
        user.setPassword(userModel.getPassword());
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
    public ResponseEntity<UserModel> loginUser(UserModel userModel) {
        User user = userRepository.findUserByEmail(userModel.getEmail());
        if (user.getPassword().equals(userModel.getPassword())) {
            return new ResponseEntity<UserModel>(new UserModel(user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        // alternativ lösning om du vill fånga alla nullpointers(kan hända att
        // det kastas i onödan. )
        // try{
        //     User user = userRepository.findUserByEmail(userModel.getEmail());
        //     if (user.getPassword().equals(userModel.getPassword())) {
        //         return new ResponseEntity<UserModel>(new UserModel(user), HttpStatus.OK);
        //     } else {
        //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        //     }
        // }catch(NullPointerException e){
        //     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        // }
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
        user.setPassword(userModel.getPassword());
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

}