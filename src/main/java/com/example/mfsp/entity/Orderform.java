package com.example.mfsp.entity;


public class Orderform {

  private long orderFormId;
  private long orderFormClass;
  private long userId;
  private java.sql.Timestamp realityRentalTime;
  private java.sql.Timestamp startTime;
  private java.sql.Timestamp preconcertedReturnTime;
  private java.sql.Timestamp realityReturmTime;
  private String orderFormAddress;
  private String totalPrice;
  private String remark;
  private String orderStatus;


  public long getOrderFormId() {
    return orderFormId;
  }

  public void setOrderFormId(long orderFormId) {
    this.orderFormId = orderFormId;
  }


  public long getOrderFormClass() {
    return orderFormClass;
  }

  public void setOrderFormClass(long orderFormClass) {
    this.orderFormClass = orderFormClass;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public java.sql.Timestamp getRealityRentalTime() {
    return realityRentalTime;
  }

  public void setRealityRentalTime(java.sql.Timestamp realityRentalTime) {
    this.realityRentalTime = realityRentalTime;
  }


  public java.sql.Timestamp getStartTime() {
    return startTime;
  }

  public void setStartTime(java.sql.Timestamp startTime) {
    this.startTime = startTime;
  }


  public java.sql.Timestamp getPreconcertedReturnTime() {
    return preconcertedReturnTime;
  }

  public void setPreconcertedReturnTime(java.sql.Timestamp preconcertedReturnTime) {
    this.preconcertedReturnTime = preconcertedReturnTime;
  }


  public java.sql.Timestamp getRealityReturmTime() {
    return realityReturmTime;
  }

  public void setRealityReturmTime(java.sql.Timestamp realityReturmTime) {
    this.realityReturmTime = realityReturmTime;
  }


  public String getOrderFormAddress() {
    return orderFormAddress;
  }

  public void setOrderFormAddress(String orderFormAddress) {
    this.orderFormAddress = orderFormAddress;
  }


  public String getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(String totalPrice) {
    this.totalPrice = totalPrice;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }


  public String getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(String orderStatus) {
    this.orderStatus = orderStatus;
  }

}
