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

	public Organization addEmployeeToOrganization(Long organizationId, Set<Long> userId) {
		Organization organization = organizationRepository.findOrganizationById(organizationId);
		Set<User> users = organization.getUser();

		for (Long newEmployee : userId) {
			// boolean added = false;
			System.out.println(newEmployee);
			User user = userRepository.findUserById(newEmployee);
			organization.getUser().add(user);
		}
		System.out.println(users.size());
		organization.setCompanyName("asd");
		organizationRepository.save(organization);
		return null;
	}

	public List<Organization> getAllOrganizations() {
		return organizationRepository.findAll();
	}

}