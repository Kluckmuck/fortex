package com.fortex.backend.user;

import lombok.*;

import javax.persistence.*;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private Organization organization;


}
