package com.fortex.backend.user;

import lombok.*;

import javax.persistence.*;

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

}
