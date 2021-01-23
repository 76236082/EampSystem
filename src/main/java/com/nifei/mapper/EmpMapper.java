package com.nifei.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nifei.bean.Emp;

public interface EmpMapper extends BaseMapper<Emp> {
    int deleteByPrimaryKey(Integer id);

    int insert(Emp record);

    int insertSelective(Emp record);

    Emp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);
}