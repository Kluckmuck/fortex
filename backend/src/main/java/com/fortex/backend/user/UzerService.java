package com.fortex.backend.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UzerService {

    @Autowired
    private UzerRepository uzerRepository;

    public UzerModel createUser(UzerModel uzerModel) {
        Uzer uzer = new Uzer();
        uzer.setEmail(uzerModel.getEmail());
        uzer.setLastName(uzerModel.getLastName());
        uzer.setName(uzerModel.getName());
        uzer.setPassword(uzerModel.getPassword());
        return new UzerModel(uzerRepository.save(uzer));
    }

    public List<UzerModel> getAllUsers() {
        List<Uzer> uzerList = uzerRepository.findAll();
        return convertUserListToUserModelList(uzerList);
    }

    public UzerModel getUserById(Long id) {
        Uzer uzer = uzerRepository.getOne(id);
        return new UzerModel(uzer);
    }

    public ResponseEntity<Void> deleteUserById(Long id) {
        Uzer uzer = uzerRepository.getOne(id);
        if (uzer.getId() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            uzerRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

    public UzerModel updateUserById(Long id, UzerModel uzerModel) {
        Uzer uzer = uzerRepository.getOne(id);
        uzer.setEmail(uzerModel.getEmail());
        uzer.setLastName(uzerModel.getLastName());
        uzer.setName(uzerModel.getName());
        uzer.setPassword(uzerModel.getPassword());
        return new UzerModel(uzerRepository.save(uzer));
    }


    public UzerModel findUserByEmail(String email) {
        Uzer uzer = uzerRepository.findUserByEmail(email);
        return new UzerModel(uzer);
    }


    public List<UzerModel> convertUserListToUserModelList(List<Uzer> uzerList) {
        List<UzerModel> uzerModelList = new ArrayList<>();
        for (Uzer uzer : uzerList) {
            uzerModelList.add(new UzerModel(uzer));
        }
        return uzerModelList;
    }


}