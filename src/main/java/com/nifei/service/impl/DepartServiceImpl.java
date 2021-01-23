package com.nifei.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nifei.bean.Depart;
import com.nifei.mapper.DepartMapper;
import com.nifei.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartServiceImpl implements DepartService {

    @Autowired
    DepartMapper departMapper;

    @Override
    public Page<Depart> findDeparts(Long pageIndex, Long pageSize) {
        return departMapper.selectPage(new Page<>(pageIndex,pageSize),null);
    }

    @Override
    public Depart findById(Long id) {
        return departMapper.selectById(id);
    }

    @Override
    public int add(Depart depart) {
        return departMapper.insert(depart);
    }

    @Override
    public int deleteById(Long id) {
        return departMapper.deleteById(id);
    }

    @Override
    public int update(Depart depart) {
        return departMapper.updateById(depart);
    }
}
