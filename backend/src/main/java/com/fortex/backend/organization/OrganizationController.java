package com.fortex.backend.organization;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * OrganizationController
 */
@RestController
@RequestMapping(value="api/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;
    
    @PostMapping
    public Organization createNewOrganization(@RequestBody Organization organization){
        return organizationService.createNewOrganization( organization);
    }
}