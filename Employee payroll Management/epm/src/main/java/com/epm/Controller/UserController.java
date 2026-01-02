package com.epm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.epm.Model.User;
import com.epm.Repository.UserRepository;

@Controller
public class UserController {

    @Autowired
    UserRepository repository;

    @GetMapping("/userlog")
    public String userPage() {
        return "userlog"; // must match userlog.html
    }

@PostMapping("/userlog")
public String userLogin(@ModelAttribute User user) {

    User existingUser = repository.findByUsername(user.getUsername());

    if (existingUser != null) {
        // user already exists → login success
        return "employee";   // or dashboard
    }

    // new user → register
    repository.save(user);
    return "employee";
}

}
