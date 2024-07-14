package com.demo.demo.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.UserData;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class Controller {

    private int add(List<Integer> e){
        int sum = 0;
        for(Integer i: e){
            sum += i;
        }
        return sum;
    }

    @GetMapping("/add/{username}")
    @ResponseBody
    public String getMethodName(@RequestParam(name = "nums") List<Integer> elements, @PathVariable(name = "username") String something) {

        int res = add(elements);
        return "hello "+something+". Your Sum is "+res;
    }

    @GetMapping("/api/data")
    public UserData getMethodName(@RequestParam Map<String, String> data) {
        return new UserData(Integer.parseInt(data.get("id")), data.get("name"), Integer.parseInt(data.get("age")));
    }

    @GetMapping("/thymeleafTemplate")
    public String getMethodName(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "thymeleafTemplate";
    }
    
        
    // @PostMapping("/testing")
    // public UserData postMethodName(@RequestBody UserData data) {
    //     return data;
    // }
    
}
