package com.example.mfsp.entity;

public class Clothingrecomment {

  private long clothingRecommentId;
  private long userId;
  private long clothingClassId;
  private long recommendWeight;


  public long getClothingRecommentId() {
    return clothingRecommentId;
  }

  public void setClothingRecommentId(long clothingRecommentId) {
    this.clothingRecommentId = clothingRecommentId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getClothingClassId() {
    return clothingClassId;
  }

  public void setClothingClassId(long clothingClassId) {
    this.clothingClassId = clothingClassId;
  }


  public long getRecommendWeight() {
    return recommendWeight;
  }

  public void setRecommendWeight(long recommendWeight) {
    this.recommendWeight = recommendWeight;
  }

}
