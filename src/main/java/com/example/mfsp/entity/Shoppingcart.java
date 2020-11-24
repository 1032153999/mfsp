package com.example.mfsp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "shoppingcart")
public class Shoppingcart {

    //null int(10)
    private int shoppingcartid;

    //null int(10)
    private int userid;

    //null int(10)
    private int clothingid;

    //null int(10)
    private int sccnum;

    @Override
    public String toString() {
        return "Shoppingcart{" +
                "shoppingcartid=" + shoppingcartid +
                ", userid=" + userid +
                ", clothingid=" + clothingid +
                ", sccnum=" + sccnum +
                '}';
    }

    @Id
    @GeneratedValue()
    @Column(name = "shoppingCartID")
    public int getShoppingcartid() {
        return shoppingcartid;
    }

    public void setShoppingcartid(int shoppingcartid) {
        this.shoppingcartid = shoppingcartid;
    }


    @Column(name = "userID")
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }


    @Column(name = "clothingID")
    public int getClothingid() {
        return clothingid;
    }

    public void setClothingid(int clothingid) {
        this.clothingid = clothingid;
    }


    @Column(name = "SCCNum")
    public int getSccnum() {
        return sccnum;
    }

    public void setSccnum(int sccnum) {
        this.sccnum = sccnum;
    }

}
