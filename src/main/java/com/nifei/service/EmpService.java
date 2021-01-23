package com.nifei.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nifei.bean.Emp;

import java.util.Map;

public interface EmpService {

    Page<Emp> findEmps(int pageIndex, int pageSize, Map<String,Object> queryMap);

    Emp findById(Integer id);

    int add(Emp emp);

    int deleteById(Integer id);

    int update(Emp emp);
}
