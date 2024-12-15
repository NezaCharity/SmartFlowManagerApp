package com.example.repositories;

import com.example.models.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Marks this class as a Spring repository bean
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper to map ResultSet to User object
    private RowMapper<User> userRowMapper = (rs, rowNum) -> {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setEmail(rs.getString("email"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setPhone(rs.getString("phone"));
        user.setRoleId(rs.getInt("role_id"));

        return user;
    };

    // Fetch all users
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, userRowMapper);
    }

    // Fetch user by username
    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{username}, userRowMapper);
    }

    // Add a new user
    public void createUser(User user) {
        String sql = "INSERT INTO users (username, password, email, first_name, last_name, phone, role_id, is_active, created_at, updated_at) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), 
                user.getFirstName(), user.getLastName(), user.getPhone(), 
                user.getRoleId(), user.getIsActive(), user.getCreatedAt(), user.getUpdatedAt());
    }
    
    
    //update an existing user
    public void updateUser(User user) {
        String sql = "UPDATE users SET username = ?, password = ?, email = ?, first_name = ?, last_name = ?, phone = ?, role_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getRole(), user.getId());
    }
    //fetch user by Email
    public User getUserByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{email}, userRowMapper);
    }
}
