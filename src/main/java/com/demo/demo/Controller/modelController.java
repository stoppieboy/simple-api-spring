package com.demo.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.demo.UserData;




@Controller
public class modelController {

    @PostMapping("/save")
    public String postMethodName(@ModelAttribute UserData user, Model model) {
        model.addAttribute("user", user);
        return "user-data";
    }
    

    @GetMapping("/thymeleafTemplate")
    public String getMethodName() {
        return "index";
    }
    
}
