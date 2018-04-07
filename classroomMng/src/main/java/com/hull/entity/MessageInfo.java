package com.hull.entity;

import com.hull.common.IdEntity;

import java.util.Date;

/**
WARNING: 
this code is generated by CodeMonkey
please DO NOT modify this file
**/
public class MessageInfo extends IdEntity {
  /**
  发信人
  **/
  private Integer sendMan;
  /**
  收信组
  **/
  private Integer receiveTeamId;
  /**
  发送时间
  **/
  private Date sendTime;
  /**
  状态  0-已发送 1-已接收
  **/
  private String status;
  /**
  消息内容
  **/
  private String content;
  private Date updateTime;

  public Integer getSendMan() {
  	return sendMan;
  }
	
  public void setSendMan(Integer sendMan) {
    this.sendMan = sendMan;
  }

  public Integer getReceiveTeamId() {
    return receiveTeamId;
  }

  public void setReceiveTeamId(Integer receiveTeamId) {
    this.receiveTeamId = receiveTeamId;
  }

  public Date getSendTime() {
  	return sendTime;
  }
	
  public void setSendTime(Date sendTime) {
    this.sendTime = sendTime;
  }
	
  public String getStatus() {
  	return status;
  }
	
  public void setStatus(String status) {
    this.status = status;
  }
	
  public String getContent() {
  	return content;
  }
	
  public void setContent(String content) {
    this.content = content;
  }
	
  public Date getUpdateTime() {
  	return updateTime;
  }
	
  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }
	
}
