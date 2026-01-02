package com.epm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.epm.Model.Payroll;
import com.epm.Repository.PayrollRepository;

@Controller
public class PayrollController {

    @Autowired
    PayrollRepository payrollRepository;

    // Show payroll form
    @GetMapping("/payroll")
    public String payrollPage() {
        return "payroll";   // payroll.html
    }

    // Save payroll
    @PostMapping("/payrolls")
    public String savePayroll(@ModelAttribute Payroll payroll) {
        payrollRepository.save(payroll);
        return "redirect:/payroll-list";
    }

    // ✅ THIS WAS MISSING
    @GetMapping("/payroll-list")
    public String payrollList(Model model) {
        List<Payroll> payrolls = payrollRepository.findAll();
        model.addAttribute("payrolls", payrolls);
        return "payroll-list";   // payroll-list.html
    }
}
