package com.example.controllers;

import com.example.models.Role;
import com.example.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * Get all roles.
     * @return List of roles
     */
    @GetMapping("/")
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        return ResponseEntity.ok(roles);
    }

    /**
     * Create a new role.
     * @param role Role object
     * @return Success message
     */
    @PostMapping("/")
    public ResponseEntity<String> createRole(@RequestBody Role role) {
        roleService.createRole(role);
        return ResponseEntity.ok("Role created successfully");
    }
}
