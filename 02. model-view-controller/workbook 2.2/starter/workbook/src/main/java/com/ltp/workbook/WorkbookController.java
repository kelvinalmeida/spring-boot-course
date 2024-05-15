package com.ltp.workbook;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorkbookController {
    
    @GetMapping("/")
    public String getShows() {

        Map<String, Show> model = new HashMap<>();

        model.put("show1", new Show("Breaking Bad", "Ozymandias", 10.0));
        model.put("show2", new Show("Attack on Titan", "Hero", 9.9));
        model.put("show3", new Show("Attack on Titan", "Perfect Game", 9.9));
        model.put("show4", new Show("Star Wars: The Clone Wars", "Victory and Death", 9.9));
        model.put("show5", new Show("Mr. Robot", "407 Proxy Authentication Required", 9.9));

        return "shows";
    }

}
