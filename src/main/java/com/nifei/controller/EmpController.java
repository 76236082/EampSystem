package com.nifei.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nifei.bean.Emp;
import com.nifei.service.EmpService;
import com.nifei.utils.PageNavUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping("emp")
public class EmpController {

    @Autowired
    EmpService empService;

    @RequestMapping("/list/{pageIndex}/{pageSize}")
    public String getEmpList(@PathVariable(value = "pageIndex",required = false)Integer pageIndex,
                             @PathVariable(value = "pageSize",required = false)Integer pageSize,
                             @RequestParam(value = "nameLike",required = false)
                                         String name, Model model){
        HashMap<String, Object> map = new HashMap<>();

        Page<Emp> page = empService.findEmps(pageIndex, pageSize, map);
        int[] pageNav = PageNavUtils.pageNav(pageIndex, page.getTotal(), pageSize.longValue(), 7);
        model.addAttribute("page",page);
        model.addAttribute("pageNav",pageNav);
        return "emp_list";
    }
}
