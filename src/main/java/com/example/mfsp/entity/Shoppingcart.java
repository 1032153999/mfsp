package com.example.mfsp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "shoppingcart")
public class Shoppingcart {

    //null int(10)
    @Id
    private Integer shoppingcartid;

    //null int(10)
    private Integer userid;

    //null int(10)
    private Integer clothingid;

    //null int(10)
    private Integer sccnum;

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
    public Integer getShoppingcartid() {
        return shoppingcartid;
    }

    public void setShoppingcartid(Integer shoppingcartid) {
        this.shoppingcartid = shoppingcartid;
    }


    @Column(name = "userID")
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }


    @Column(name = "clothingID")
    public Integer getClothingid() {
        return clothingid;
    }

    public void setClothingid(Integer clothingid) {
        this.clothingid = clothingid;
    }


    @Column(name = "SCCNum")
    public Integer getSccnum() {
        return sccnum;
    }

    public void setSccnum(Integer sccnum) {
        this.sccnum = sccnum;
    }

}
