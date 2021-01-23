package com.nifei.controller;

import com.nifei.bean.User;
import com.nifei.commons.Result;
import com.nifei.commons.ResultCode;
import com.nifei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @PostMapping("login")
    public Result doLogin(User user,String sysCode,HttpSession session){
        //1.判断传入验证码是否正确
        String code = (String)session.getAttribute("sysCode");
        if (code.equalsIgnoreCase(sysCode)){
            //2.查询用户名和密码是否正确
            User loigin = userService.Loigin(user);
            if (null!=loigin){
                session.setAttribute("username",user.getUsername());
                return Result.success();
            }else {
                //返回用户名或者密码错误
                return Result.fail(ResultCode.USERNAME_OR_PASSWORD_ERROR);
            }

        }else {
            //返回验证码错误
            return Result.fail(ResultCode.SYSTEM_CODE_ERROR);
        }
    }

    @RequestMapping("layout")
    public String layout(HttpSession session){
        //session失效
        session.invalidate();
        return "login";
    }
}
