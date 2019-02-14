package com.fortex.backend.user;

import lombok.*;

import java.util.List;

import javax.persistence.*;

import com.fortex.backend.organization.Organization;
import com.fortex.backend.user.role.Role;

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

    @ElementCollection(fetch = FetchType.EAGER)
    List<Role> roles;
  
    // An organization can have many employees. TODO: EAGER might become a
    // problem due to its fast loading. 
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "organization_id", nullable = true)
    private Organization organization;


}
