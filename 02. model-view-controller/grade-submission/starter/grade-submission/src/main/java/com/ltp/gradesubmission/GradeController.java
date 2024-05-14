package com.ltp.gradesubmission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class GradeController {
    
    @GetMapping("/grade")
    public String gerGrades(Model model) {
        Grade grade = new Grade("Harry", "Portions", "C-"); // POJO
        model.addAttribute("grade", grade);

        return "grades";
    }
    
}