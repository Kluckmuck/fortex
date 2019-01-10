package com.fortex.backend.user;

import com.fortex.backend.organization.Organization;

import lombok.*;


@Getter
@Setter
@ToString
@Data
@NoArgsConstructor

public class UserModel {


    public UserModel(User user) {
        setId(user.getId());
        setEmail(user.getEmail());
        setLastName(user.getLastName());
        setName(user.getName());
        setPassword(user.getPassword());
        if(user.getOrganization() != null){
            setOrganization(user.getOrganization());
        }
    }

    private Long id;

    private String email;
    private String name;
    private String lastName;
    private String password;
    private Organization organization;


}
