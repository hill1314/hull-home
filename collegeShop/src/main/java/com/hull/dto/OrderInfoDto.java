package com.hull.dto;

import com.hull.common.IdEntity;
import com.hull.entity.OrderItem;
import com.hull.entity.SendInfo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
订单信息
**/
public class OrderInfoDto extends IdEntity {
  /**
  类型 1-进货单 2-出货单
  **/
  private String orderType;
  /**
  配送类型 0-不需要配置 1-需要配送
  **/
  private String sendType;
  /**
  总价
  **/
  private BigDecimal totalAmount;
  /**
  订单状态 0-未支付 1-已支付
  **/
  private String status;
  private Date createTime;
  private Date updateTime;

  private List<OrderItem> orderItems;
  private SendInfo sendInfo;

  public String getOrderType() {
  	return orderType;
  }
	
  public void setOrderType(String orderType) {
    this.orderType = orderType;
  }
	
  public String getSendType() {
  	return sendType;
  }
	
  public void setSendType(String sendType) {
    this.sendType = sendType;
  }
	
  public BigDecimal getTotalAmount() {
  	return totalAmount;
  }
	
  public void setTotalAmount(BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
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

  public List<OrderItem> getOrderItems() {
    return orderItems;
  }

  public void setOrderItems(List<OrderItem> orderItems) {
    this.orderItems = orderItems;
  }

  public SendInfo getSendInfo() {
    return sendInfo;
  }

  public void setSendInfo(SendInfo sendInfo) {
    this.sendInfo = sendInfo;
  }
}
