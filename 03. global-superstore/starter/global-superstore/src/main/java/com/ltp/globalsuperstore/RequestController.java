package com.ltp.globalsuperstore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RequestController {

    private List<Item> items = new ArrayList<>();

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {

        int index = getIdItem(id);

        if(index != Constants.NOT_EXIST) {
            model.addAttribute("item", items.get(index));
        } else {
            model.addAttribute("item", new Item());
        }
        
        model.addAttribute("categories", Constants.CATEGORIES);

        return "form";
    }

    @GetMapping("/inventory")
    public String getInventory(Model model) {
        model.addAttribute("items", this.items);
        return "inventory";
    }

    @PostMapping("/submitItem")
    public String handleSubmit(Item item, RedirectAttributes redirectAttributes) {
        
        int index = getIdItem(item.getId());

        if(index != Constants.NOT_EXIST) {
            items.set(index, item);
        } else {
            items.add(item);
        }

        redirectAttributes.addFlashAttribute("status", Constants.SUCCESS_STATUS);

        return "redirect:/inventory";
    }


    public int getIdItem(String id) {
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getId().equals(id)) return i;
        }

        return Constants.NOT_EXIST;
    }

    public boolean within5Days(Date newDate, Date oldDate) {
        long diff = Math.abs(newDate.getTime() - oldDate.getTime());
        return (int) (TimeUnit.MILLISECONDS.toDays(diff)) <= 5;
    }

}
