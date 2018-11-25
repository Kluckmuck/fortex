package com.fortex.backend.user;

import lombok.*;


@Getter
@Setter
@ToString
@Data
@NoArgsConstructor

public class UzerModel {


    public UzerModel(Uzer uzer) {
        setId(uzer.getId());
        setEmail(uzer.getEmail());
        setLastName(uzer.getLastName());
        setName(uzer.getName());
        setPassword(uzer.getPassword());
    }

    private Long id;

    private String email;
    private String name;
    private String lastName;
    private String password;


}
