package com.example.mfsp.entity;

public class Favourites {

  private long favouritesId;
  private long clothingId;
  private long userId;


  public long getFavouritesId() {
    return favouritesId;
  }

  public void setFavouritesId(long favouritesId) {
    this.favouritesId = favouritesId;
  }


  public long getClothingId() {
    return clothingId;
  }

  public void setClothingId(long clothingId) {
    this.clothingId = clothingId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

}
