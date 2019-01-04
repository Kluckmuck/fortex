package com.fortex.backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/api/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<UserModel> createNewUser(@RequestBody UserModel userModel){
        return  new ResponseEntity<>(userService.createUser(userModel), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers(){

        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable Long id){

        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserModel> updateUserById(@PathVariable Long id, @RequestBody UserModel userModel){

        return new ResponseEntity<>(userService.updateUserById(id, userModel), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id ){
        return userService.deleteUserById(id);
    }


    @GetMapping("/{email}")
    public ResponseEntity<UserModel> findUserByEmail (@PathVariable String email){
        return new ResponseEntity<>(userService.findUserByEmail(email), HttpStatus.OK);
    }
}
