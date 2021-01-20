package com.nifei.controller;

import com.nifei.utils.SystemCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("images")
public class SystemCodeController {

    @Autowired
    SystemCodeUtils codeUtils;

    @RequestMapping("code")
    public void getCode(HttpServletRequest request, HttpServletResponse response){
        try {
            codeUtils.creatCode(request,response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
