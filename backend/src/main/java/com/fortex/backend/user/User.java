package com.fortex.backend.user;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fortex.backend.security.role.Role;

@Getter
@Setter
@Data
@ToString
@Entity
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

    public void addRoleToUser(Role role){
        this.roles.add(role);
    }
}
