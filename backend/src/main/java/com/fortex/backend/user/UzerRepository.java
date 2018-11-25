package com.fortex.backend.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UzerRepository extends JpaRepository<Uzer, Long> {

    List<Uzer> findAll();

    Uzer findUserByEmail(String email);


}

