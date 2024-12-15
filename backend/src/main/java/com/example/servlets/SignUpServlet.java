package com.example.servlets;

import com.example.models.User;
import com.example.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet("/signup")
@Component
public class SignUpServlet extends HttpServlet {

    @Autowired
    private AuthService authService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");
        String phone = req.getParameter("phone");
        String roleIdStr = req.getParameter("role_id");

        if (username.isEmpty() || password.isEmpty() || email.isEmpty() || roleIdStr == null) {
            req.setAttribute("errorMessage", "All required fields must be filled.");
            req.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(req, resp);
            return;
        }

        if (!email.matches("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
            req.setAttribute("errorMessage", "Invalid email format.");
            req.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(req, resp);
            return;
        }

        // Encrypt password
        String encryptedPassword = passwordEncoder.encode(password);

        // Create new User object
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(encryptedPassword);
        newUser.setEmail(email);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setPhone(phone);
        newUser.setRoleId(Integer.parseInt(roleIdStr)); // Role ID
        newUser.setIsActive(true);

        // Set timestamps
        newUser.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        newUser.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        // Register the user
        boolean isRegistered = authService.registerUser(newUser);

        if (isRegistered) {
            resp.sendRedirect("/login");
        } else {
            req.setAttribute("errorMessage", "User registration failed. Username or email may already exist.");
            req.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(req, resp);
        }
    }
}
