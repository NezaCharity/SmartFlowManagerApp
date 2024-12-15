package com.example.repositories;

import com.example.models.Role;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleRepository {

    private final JdbcTemplate jdbcTemplate;

    public RoleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper to map ResultSet to Role object
    private final RowMapper<Role> roleRowMapper = (rs, rowNum) -> {
        Role role = new Role();
        role.setId(rs.getInt("id"));
        role.setRoleName(rs.getString("name"));
        return role;
    };

    // Fetch all roles
    public List<Role> getAllRoles() {
        String sql = "SELECT * FROM roles";
        return jdbcTemplate.query(sql, roleRowMapper);
    }

    // Fetch role by ID
    public Role getRoleById(int id) {
        String sql = "SELECT * FROM roles WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, roleRowMapper);
    }

    // Add a new role
    public void createRole(Role role) {
        String sql = "INSERT INTO roles (name) VALUES (?)";
        jdbcTemplate.update(sql, role.getRoleName());
    }

    // Update an existing role
    public void updateRole(Role role) {
        String sql = "UPDATE roles SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, role.getRoleName(), role.getId());
    }

    // Delete a role
    public void deleteRole(int id) {
        String sql = "DELETE FROM roles WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
