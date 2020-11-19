package com.example.mfsp.entity;

public class Clothingsize {

  private long clothingSizeId;
  private long clothingId;
  private String sizeName;


  public long getClothingSizeId() {
    return clothingSizeId;
  }

  public void setClothingSizeId(long clothingSizeId) {
    this.clothingSizeId = clothingSizeId;
  }


  public long getClothingId() {
    return clothingId;
  }

  public void setClothingId(long clothingId) {
    this.clothingId = clothingId;
  }


  public String getSizeName() {
    return sizeName;
  }

  public void setSizeName(String sizeName) {
    this.sizeName = sizeName;
  }

}
