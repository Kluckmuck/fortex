package com.fortex.backend.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * OrganizationService
 */
@Service
public class OrganizationService {

    @Autowired
    OrganizationRepository organizationRepository;

	public Organization createNewOrganization(Organization organization) {
		return organizationRepository.save(organization);
	}

    
}