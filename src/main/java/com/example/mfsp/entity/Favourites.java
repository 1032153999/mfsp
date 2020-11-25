package com.example.mfsp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "favourites")
public class Favourites {

    //null int(10)
    @Id
    private Integer favouritesid;

    //null int(10)
    private Integer clothingid;

    //null int(10)
    private Integer userid;


    @Id
    @GeneratedValue()
    @Column(name = "favouritesID")
    public Integer getFavouritesid() {
        return favouritesid;
    }

    public void setFavouritesid(Integer favouritesid) {
        this.favouritesid = favouritesid;
    }


    @Column(name = "clothingID")
    public Integer getClothingid() {
        return clothingid;
    }

    public void setClothingid(Integer clothingid) {
        this.clothingid = clothingid;
    }


    @Column(name = "userID")
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Favourites{" +
                "favouritesid=" + favouritesid +
                ", clothingid=" + clothingid +
                ", userid=" + userid +
                '}';
    }
}
