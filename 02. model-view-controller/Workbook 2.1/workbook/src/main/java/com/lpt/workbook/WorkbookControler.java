package com.lpt.workbook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WorkbookControler {
    

    @GetMapping("/")
    public String getShow() {
        return "shows";
    }
}
