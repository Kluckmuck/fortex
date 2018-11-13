package com.fortex.backend.user;

import lombok.*;


@Getter
@Setter
@ToString
@Data
@NoArgsConstructor


public class UserModel {


    public UserModel(User user) {
        setId(getId());
        setEmail(user.getEmail());
        setLastName(user.getLastName());
        setName(user.getName());
        setPassword(user.getPassword());
    }

    private Long id;

    private String email;
    private String name;
    private String lastName;
    private String password;


}
