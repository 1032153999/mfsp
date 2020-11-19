package com.example.mfsp.entity;

public class Clothinginorder {

  private long clothingInOrderId;
  private long clothingId;
  private String clothingPrice;
  private String clothingName;
  private String clothingDescr;
  private long orderFormId;
  private long cioNum;


  public long getClothingInOrderId() {
    return clothingInOrderId;
  }

  public void setClothingInOrderId(long clothingInOrderId) {
    this.clothingInOrderId = clothingInOrderId;
  }


  public long getClothingId() {
    return clothingId;
  }

  public void setClothingId(long clothingId) {
    this.clothingId = clothingId;
  }


  public String getClothingPrice() {
    return clothingPrice;
  }

  public void setClothingPrice(String clothingPrice) {
    this.clothingPrice = clothingPrice;
  }


  public String getClothingName() {
    return clothingName;
  }

  public void setClothingName(String clothingName) {
    this.clothingName = clothingName;
  }


  public String getClothingDescr() {
    return clothingDescr;
  }

  public void setClothingDescr(String clothingDescr) {
    this.clothingDescr = clothingDescr;
  }


  public long getOrderFormId() {
    return orderFormId;
  }

  public void setOrderFormId(long orderFormId) {
    this.orderFormId = orderFormId;
  }


  public long getCioNum() {
    return cioNum;
  }

  public void setCioNum(long cioNum) {
    this.cioNum = cioNum;
  }

}
