package com.ltp.gradesubmission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class GradeController {
    
    List<Grade> studentGrade = new ArrayList<>();

    @GetMapping("/grade")
    public String getGrades(Model model) {

        model.addAttribute("grades", studentGrade);

        return "grades";
    }

    @GetMapping("/")
    public String getForm(Model model) {

        model.addAttribute("grade", new Grade());

        return "form";
    }

    @PostMapping("/submitForm")
    public String submitForm(Grade grade) {
        studentGrade.add(grade);
        return "redirect:/grade";
    }
    
}
