package com.epm.Controller;
import com.epm.Model.Employee;
import com.epm.Repository.EmployeeRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeRepository repository;

    // -------------------------------
    // EMPLOYEE FORM PAGE
    // -------------------------------
    @GetMapping("/employee")
    public String employeeForm(HttpSession session) {
        if (session.getAttribute("admin") == null) {
            return "redirect:/login";
        }
        return "employee";
    }

    // -------------------------------
    // SAVE EMPLOYEE
    // -------------------------------
    @PostMapping("/employee")
    public String saveEmployee(Employee employee, HttpSession session) {
        if (session.getAttribute("admin") == null) {
            repository.save(employee);
            return "redirect:/main";
        }
        return "redirect:/payroll";
    }

}
