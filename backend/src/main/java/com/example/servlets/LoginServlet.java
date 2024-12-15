package com.example.servlets;

import com.example.models.User;
import com.example.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
@Component // Marks this servlet as a Spring component
public class LoginServlet extends HttpServlet {

    @Autowired // Injects AuthService
    private AuthService authService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = authService.authenticateUser(username, password);

        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect("/dashboard");
        } else {
            req.setAttribute("errorMessage", "Invalid username or password.");
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        }
    }
}
