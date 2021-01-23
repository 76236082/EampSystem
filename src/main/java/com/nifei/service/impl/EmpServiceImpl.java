package com.nifei.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nifei.bean.Emp;
import com.nifei.mapper.EmpMapper;
import com.nifei.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    EmpMapper empMapper;

    @Override
    public Page<Emp> findEmps(int pageIndex,int pageSize,Map<String, Object> queryMap) {
        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
        Page<Emp> page = new Page<>(pageIndex, pageSize);
        if (queryMap.get("name")!=null){
            wrapper.like("name",queryMap.get("name").toString().trim());
            return empMapper.selectPage(page,null);
        }
        return empMapper.selectPage(page,wrapper);
    }

    @Override
    public Emp findById(Integer id) {
        return empMapper.selectById(id);
    }

    @Override
    public int add(Emp emp) {
        return empMapper.insert(emp);
    }

    @Override
    public int deleteById(Integer id) {
        return empMapper.deleteById(id);
    }

    @Override
    public int update(Emp emp) {
        return empMapper.updateById(emp);
    }
}
