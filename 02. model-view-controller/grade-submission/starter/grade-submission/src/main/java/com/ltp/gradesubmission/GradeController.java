package com.ltp.gradesubmission;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class GradeController {
    
    List<Grade> studentGrade = Arrays.asList(new Grade("Harry", "Portions", "C-"), new Grade("Kelvin", "Ingles", "A+"), new Grade("Ana", "Ciências", "A"));   

    @GetMapping("/grade")
    public String gerGrades(Model model) {

        model.addAttribute("grades", studentGrade);

        return "grades";
    }
    
}
