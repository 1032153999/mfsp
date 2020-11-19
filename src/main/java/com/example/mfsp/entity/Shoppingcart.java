package com.example.mfsp.entity;

public class Shoppingcart {

  private long shoppingCartId;
  private long userId;
  private long clothingId;
  private long sccNum;


  public long getShoppingCartId() {
    return shoppingCartId;
  }

  public void setShoppingCartId(long shoppingCartId) {
    this.shoppingCartId = shoppingCartId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getClothingId() {
    return clothingId;
  }

  public void setClothingId(long clothingId) {
    this.clothingId = clothingId;
  }


  public long getSccNum() {
    return sccNum;
  }

  public void setSccNum(long sccNum) {
    this.sccNum = sccNum;
  }

}
