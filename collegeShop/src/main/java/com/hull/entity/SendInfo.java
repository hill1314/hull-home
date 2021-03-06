package com.hull.entity;

import com.hull.common.IdEntity;

import java.util.Date;

/**
WARNING: 
this code is generated by CodeMonkey
please DO NOT modify this file
**/
public class SendInfo extends IdEntity {
  private Integer orderId;
  /**
  收货人
  **/
  private String sendTo;
  /**
  手机号码
  **/
  private String mobile;
  /**
  地址
  **/
  private String address;
  /**
  状态 0-未派送 1-已派送
  **/
  private String status;
  private Date createTime;
  private Date updateTime;

  public Integer getOrderId() {
  	return orderId;
  }
	
  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }
	
  public String getSendTo() {
  	return sendTo;
  }
	
  public void setSendTo(String sendTo) {
    this.sendTo = sendTo;
  }
	
  public String getMobile() {
  	return mobile;
  }
	
  public void setMobile(String mobile) {
    this.mobile = mobile;
  }
	
  public String getAddress() {
  	return address;
  }
	
  public void setAddress(String address) {
    this.address = address;
  }
	
  public String getStatus() {
  	return status;
  }
	
  public void setStatus(String status) {
    this.status = status;
  }
	
  public Date getCreateTime() {
  	return createTime;
  }
	
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
	
  public Date getUpdateTime() {
  	return updateTime;
  }
	
  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }
	
}
