package com.nifei.bean;


import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_depart")
public class Depart {

  @TableId(type = IdType.AUTO)
  private Long id;
  private String name;
  private Long count;
  private String createtime;
  private Long flag;
  @TableLogic
  private Long del;



}
