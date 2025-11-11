package com.smartattendance.controller;

import java.util.List;
import java.util.Map;
import com.smartattendance.model.Student;
import com.smartattendance.dao.StudentDAO;
import com.smartattendance.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private ReportService reportService;

    @GetMapping("/login")
    public String login() { return "login"; }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("students", studentDAO.findAll());
        List<Map<String,Object>> summary = reportService.attendanceSummary();
        model.addAttribute("summary", summary);
        return "dashboard";
    }

    @PostMapping("/students")
    public String addStudent(@RequestParam String name, @RequestParam String roll,
                             @RequestParam String course, @RequestParam String semester){
        Student s = new Student();
        s.setName(name); s.setRoll_no(roll); s.setCourse(course); s.setSemester(semester);
        studentDAO.save(s);
        return "redirect:/dashboard";
    }
}
