package com.ltp.gradesubmission;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class GradeController {
    
    List<Grade> studentGrade = new ArrayList<>(); 

    @GetMapping("/grade")
    public String gerGrades(Model model) {

        studentGrade.add(new Grade("Harry", "Portions", "C-"));
        studentGrade.add(new Grade("Kelvin", "Ingles", "A+"));
        studentGrade.add(new Grade("Ana", "Ciências", "A"));

        model.addAttribute("grades", studentGrade);

        return "grades";
    }
    
}
