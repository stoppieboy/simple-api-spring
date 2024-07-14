package com.demo.demo.Controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


public class errcontroller implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(PATH)
    @ResponseBody
    public String getErrorPath(){
        return "Some Error occured";
    }
}
