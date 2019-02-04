package com.fortex.backend.organization;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * OrganizationRepository
 */
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    List<Organization> findAll();

	Organization findOrganizationById(Long id);
    
}