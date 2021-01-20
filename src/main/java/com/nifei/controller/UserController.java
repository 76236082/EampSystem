package com.nifei.controller;

import com.nifei.bean.User;
import com.nifei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("login")
    public void doLogin(User user,String sysCode,HttpSession session){
        //1.判断传入验证码是否正确
        String code = (String)session.getAttribute("sysCode");
        if (code.equals(sysCode)){

            //2.查询用户名和密码是否正确
            User loigin = userService.Loigin(user);
            if (null!=loigin){
                return;
            }else {
                //返回用户名或者密码错误
            }

        }else {
            //返回验证码错误
        }
    }
}
