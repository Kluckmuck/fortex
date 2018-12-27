package com.fortex.backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value ="/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public boolean login(@RequestBody User user) {
        return
          user.getEmail().equals("email") && user.getPassword().equals("password");
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity<UserModel> createNewUser(@RequestBody UserModel userModel){
        return  new ResponseEntity<>(userService.createUser(userModel), HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers(){

        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable Long id){

        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{id}")
    public ResponseEntity<UserModel> updateUserById(@PathVariable Long id, @RequestBody UserModel userModel){

        return new ResponseEntity<>(userService.updateUserById(id, userModel), HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id ){
        return userService.deleteUserById(id);
    }


    @GetMapping("/{email}")
    public ResponseEntity<UserModel> findUserByEmail (@PathVariable String email){
        return new ResponseEntity<>(userService.findUserByEmail(email), HttpStatus.OK);
    }


}
