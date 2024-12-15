package com.example.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.models.*;


@Controller
public class RedirectController {

    @GetMapping("/redirect")
    public String redirectAfterLogin(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            switch (user.getRoleId()) {
                case 1: return "redirect:/admin/dashboard";
                case 2: return "redirect:/donor/home";
                case 3: return "redirect:/staff/dashboard";
                default: return "redirect:/home";
            }
        }
        return "redirect:/login";
    }
}
