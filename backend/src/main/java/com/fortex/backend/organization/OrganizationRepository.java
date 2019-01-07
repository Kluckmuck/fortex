package com.fortex.backend.organization;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * OrganizationRepository
 */
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    Organization findOrganizationById(Long id);
    
}