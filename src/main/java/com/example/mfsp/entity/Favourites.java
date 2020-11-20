package com.example.mfsp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "favourites")
public class Favourites {

    //null int(10)
    private int favouritesid;

    //null int(10)
    private int clothingid;

    //null int(10)
    private int userid;


    @Id
    @GeneratedValue()
    @Column(name = "favouritesID")
    public int getFavouritesid() {
        return favouritesid;
    }

    public void setFavouritesid(int favouritesid) {
        this.favouritesid = favouritesid;
    }


    @Column(name = "clothingID")
    public int getClothingid() {
        return clothingid;
    }

    public void setClothingid(int clothingid) {
        this.clothingid = clothingid;
    }


    @Column(name = "userID")
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

}
