package com.nifei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PageControler {

    @RequestMapping("/")
    public String toIndex(HttpSession session){
        String username = (String)session.getAttribute("username");
        if (null==username){
            return "login";
        }
        return "index";
    }

    @RequestMapping("page_{templates}")
    public String toPage(@PathVariable("templates")String templates){
        return templates;
    }
}
