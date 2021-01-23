package com.nifei.bean;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * t_emp
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_emp")
public class Emp implements Serializable {

    @TableId
    private Integer id;

    private String no;

    private String name;

    /**
     * 外键  部门ID
     */
    private Integer did;

    private Integer flag;

    private String sex;

    private String email;

    private String qq;

    private String phone;

    private String createdate;

    private String photo;


    private static final long serialVersionUID = 1L;
}