package com.nifei.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nifei.bean.Depart;

import java.util.List;

public interface DepartService {

    Page<Depart> findDeparts(Long pageIndex,Long pageSize);

    Depart findById(Long id);

    int add(Depart depart);

    int deleteById(Long id);

    int update(Depart depart);
}
