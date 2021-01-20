package com.nifei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageControler {

    @RequestMapping("/")
    public String toIndex(){
        return "index";
    }

    @RequestMapping("page_{templates}")
    public String toPage(@PathVariable("templates")String templates){
        return templates;
    }
}
