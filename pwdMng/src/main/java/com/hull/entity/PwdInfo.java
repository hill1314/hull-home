package com.hull.entity;


import com.hull.common.IdEntity;

/**
WARNING: 
this code is generated by CodeMonkey
please DO NOT modify this file
**/
public class PwdInfo extends IdEntity {
  private Integer userId;
  private String type;
  private String loginCode;
  private String loginPwd;

  public Integer getUserId() {
  	return userId;
  }
	
  public void setUserId(Integer userId) {
    this.userId = userId;
  }
	
  public String getType() {
  	return type;
  }
	
  public void setType(String type) {
    this.type = type;
  }
	
  public String getLoginCode() {
  	return loginCode;
  }
	
  public void setLoginCode(String loginCode) {
    this.loginCode = loginCode;
  }
	
  public String getLoginPwd() {
  	return loginPwd;
  }
	
  public void setLoginPwd(String loginPwd) {
    this.loginPwd = loginPwd;
  }
	
}
