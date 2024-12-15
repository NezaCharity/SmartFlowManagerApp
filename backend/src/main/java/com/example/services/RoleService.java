package com.example.services;

import com.example.models.Role;
import com.example.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /**
     * Retrieves all roles.
     * @return List of Role objects
     */
    public List<Role> getAllRoles() {
        return roleRepository.getAllRoles();
    }

    /**
     * Creates a new role.
     * @param role Role object
     */
    public void createRole(Role role) {
        roleRepository.createRole(role);
    }
}
