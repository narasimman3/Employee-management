package com.epm.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    // FIXED ADMIN CREDENTIALS
    private final String ADMIN_USER = "admin";
    private final String ADMIN_PASS = "admin123";

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String username,
                          @RequestParam String password,
                          HttpSession session,
                          Model model) {

        if (username.equals(ADMIN_USER) && password.equals(ADMIN_PASS)) {
            session.setAttribute("admin", "loggedin");
            return "redirect:/payroll";
        }

        model.addAttribute("error", "Invalid Username or Password");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/main")
    public String mainpage(){
        return"main";
    }

    
}
