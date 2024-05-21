package com.ltp.gradesubmission;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class GradeController {
    
    List<Grade> studentGrade = new ArrayList<>();

    @GetMapping("/grade")
    public String getGrades(Model model) {

        model.addAttribute("grades", studentGrade);

        return "grades";
    }

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {

        Integer index = getUserIndex(id);

        model.addAttribute("grade", index == Contants.NOT_FOUND ? new Grade() : studentGrade.get(index));

        return "form";
    }

    @PostMapping("/submitForm")
    public String submitForm(Grade grade) {

        Integer index = getUserIndex(grade.getId());

        if(index == Contants.NOT_FOUND) studentGrade.add(grade);
        else studentGrade.set(index, grade);

        return "redirect:/grade";
    }


    public Integer getUserIndex(String id) {

        for (Integer i = 0; i < studentGrade.size(); i++) {
            if(studentGrade.get(i).getId().equals(id)) return i;
        }

        return Contants.NOT_FOUND;
    }
    
}
