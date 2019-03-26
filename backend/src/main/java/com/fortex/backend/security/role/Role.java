package com.fortex.backend.security.role;


import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_NATIONALMANAGER, ROLE_COORDINATOR, ROLE_INVOICING, ROLE_BUSINESSCONTROLLER, ROLE_ACCOUNTMANAGER;

    public String getAuthority() {
        return name();
    }

}