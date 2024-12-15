package com.example.servlets;

import com.example.models.User;
import com.example.services.AuthService;
import com.example.services.EmailService; // Import EmailService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/forgot-password")
@Component
public class ForgotPasswordServlet extends HttpServlet {

    @Autowired
    private AuthService authService;

    // No need to inject EmailService because it will be used statically or instantiated
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Display the forgot password page
        req.getRequestDispatcher("/WEB-INF/views/forgot-password.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");

        // Check if the email exists
        User user = authService.getUserByEmail(email);
        if (user != null) {
            // Generate a reset link (you should replace this with a secure token generation in production)
            String resetLink = generateResetLink(user);

            // Send reset link via EmailService (This assumes EmailService has been correctly set up)
            EmailService.sendEmail(user.getEmail(), "Password Reset Request", "Click the following link to reset your password: " + resetLink);
            
            req.setAttribute("successMessage", "A reset link has been sent to your email address.");
            req.getRequestDispatcher("/WEB-INF/views/forgot-password.jsp").forward(req, resp);
        } else {
            // User not found
            req.setAttribute("errorMessage", "Email not found in our system.");
            req.getRequestDispatcher("/WEB-INF/views/forgot-password.jsp").forward(req, resp);
        }
    }

    // Generate a password reset link (In a real application, generate a secure token)
    private String generateResetLink(User user) {
        // This is just a simple example; in a production system, you'd generate a secure token
        return "http://localhost:9090/reset-password?token=" + user.getId(); // Example reset link
    }
}
