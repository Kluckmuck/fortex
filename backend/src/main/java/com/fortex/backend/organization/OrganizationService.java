package com.fortex.backend.organization;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.fortex.backend.exceptions.ResourceNotFoundException;
import com.fortex.backend.user.User;
import com.fortex.backend.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	public Organization createNewOrganization(Organization organization) {
		return organizationRepository.save(organization);
	}

	public List<Organization> getAllOrganizations() {
		return organizationRepository.findAll();
	}

}