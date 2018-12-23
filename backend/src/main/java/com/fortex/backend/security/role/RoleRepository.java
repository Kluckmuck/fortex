package com.fortex.backend.security.role;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * RoleRepository
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}