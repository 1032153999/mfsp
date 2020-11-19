package com.example.mfsp.entity;

public class Clothingcomment {

  private long clothingCommentId;
  private long userId;
  private String comment;
  private long clothingId;


  public long getClothingCommentId() {
    return clothingCommentId;
  }

  public void setClothingCommentId(long clothingCommentId) {
    this.clothingCommentId = clothingCommentId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }


  public long getClothingId() {
    return clothingId;
  }

  public void setClothingId(long clothingId) {
    this.clothingId = clothingId;
  }

}
