package com.nifei.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nifei.bean.Depart;
import com.nifei.commons.Result;
import com.nifei.commons.ResultCode;
import com.nifei.service.DepartService;
import com.nifei.utils.PageNavUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("depart")
public class DepartController {

    @Autowired
    DepartService departService;

    @GetMapping("list/{pageIndex}/{pageSize}")
    public String getList(@PathVariable("pageIndex") Long pageIndex, @PathVariable("pageSize") Long pageSize, Model model){

        Page<Depart> page = departService.findDeparts(pageIndex, pageSize);
        model.addAttribute("page",page);
        model.addAttribute("pageNav", PageNavUtils.pageNav(pageIndex.intValue(),page.getTotal(),pageSize,7));
        return "dept_list";
    }

    @GetMapping("/{id}")
    public String toUpdate(@PathVariable("id") Long id, Model model){
        Depart depart = departService.findById(id);
        model.addAttribute("depart",depart);
        return "dept_update";
    }

    @ResponseBody
    @PutMapping("update")
    public Result update(Depart depart){
        int update = departService.update(depart);
        return update>0?Result.success():Result.fail(ResultCode.SERVER_ERROR);
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Long id){
        int count = departService.deleteById(id);
        return count>0?Result.success():Result.fail(ResultCode.SERVER_ERROR);
    }

    @ResponseBody
    @PostMapping("add")
    public Result add(Depart depart){
        int count = departService.add(depart);
        return count>0?Result.success():Result.fail(ResultCode.SERVER_ERROR);
    }
}
