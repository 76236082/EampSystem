package com.nifei.bean;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_user")
public class User {

  private Long id;
  private String username;
  private String usercode;
  private String password;
  private String photo;
  private String salt;
  private String lasttime;
  private String currenttime;
  private String ip;
  private String locked;
  private Long del;

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }
}
