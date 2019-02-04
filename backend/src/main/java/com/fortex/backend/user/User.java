package com.fortex.backend.user;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fortex.backend.security.role.Role;
import com.fortex.backend.organization.Organization;

@Getter
@Setter
@Data
@ToString
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String name;
    private String lastName;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();
  
    // An organization can have many employees. TODO: EAGER might become a
    // problem due to its fast loading. 
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "organization_id", nullable = true)
    private Organization organization;


    public void addRoleToUser(Role role){
        this.roles.add(role);
    }
}
