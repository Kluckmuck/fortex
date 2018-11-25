package com.fortex.backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/api/user")
public class UzerController {

    @Autowired
    private UzerService uzerService;


    @PostMapping
    public ResponseEntity<UzerModel> createNewUser(@RequestBody UzerModel uzerModel){
        return  new ResponseEntity<>(uzerService.createUser(uzerModel), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UzerModel>> getAllUsers(){

        return new ResponseEntity<>(uzerService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UzerModel> getUserById(@PathVariable Long id){

        return new ResponseEntity<>(uzerService.getUserById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UzerModel> updateUserById(@PathVariable Long id, @RequestBody UzerModel uzerModel){

        return new ResponseEntity<>(uzerService.updateUserById(id, uzerModel), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id ){
        return uzerService.deleteUserById(id);
    }


    @GetMapping("/{email}")
    public ResponseEntity<UzerModel> findUserByEmail (@PathVariable String email){
        return new ResponseEntity<>(uzerService.findUserByEmail(email), HttpStatus.OK);
    }


}
