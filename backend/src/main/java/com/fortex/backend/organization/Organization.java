package com.fortex.backend.organization;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fortex.backend.user.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Organization
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String companyName;

    @OneToMany(cascade = CascadeType.ALL,
    fetch = FetchType.LAZY,mappedBy="organization")
    private Set<User> user;
    

    public void addEmployeeToOrganization(User user){
        this.user.add(user);
    }
}