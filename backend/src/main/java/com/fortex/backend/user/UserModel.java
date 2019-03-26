package com.fortex.backend.user;

import java.util.ArrayList;
import java.util.List;

import com.fortex.backend.organization.Organization;
import com.fortex.backend.security.role.Role;

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
    private List<Role> roles = new ArrayList<>();



}
