package com.fortex.backend.organization;

import com.fortex.backend.exceptions.ResourceNotFoundException;
import com.fortex.backend.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * OrganizationService
 */
@Service
public class OrganizationService {

    @Autowired
    OrganizationRepository organizationRepository;

	@Autowired
	UserRepository userRepository;

	public Organization createNewOrganization(Long userId,Organization organization) {
		return userRepository.findById(userId).map(user -> {
			organization.setUser(user);
			return organizationRepository.save(organization);
		}).orElseThrow(() -> new ResourceNotFoundException("no such user")); 
		
	}

    
}