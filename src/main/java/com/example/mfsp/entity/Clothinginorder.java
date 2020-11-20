package com.example.mfsp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "clothinginorder")
public class Clothinginorder {

    //null int(10)
    private int clothinginorderid;

    //null int(10)
    private int clothingid;

    //null varchar(50)
    private String clothingprice;

    //null varchar(255)
    private String clothingname;

    //null varchar(255)
    private String clothingdescr;

    //null int(10)
    private int orderformid;

    //null int(10)
    private int cionum;


    @Id
    @GeneratedValue()
    @Column(name = "clothingInOrderID")
    public int getClothinginorderid() {
        return clothinginorderid;
    }

    public void setClothinginorderid(int clothinginorderid) {
        this.clothinginorderid = clothinginorderid;
    }


    @Column(name = "clothingID")
    public int getClothingid() {
        return clothingid;
    }

    public void setClothingid(int clothingid) {
        this.clothingid = clothingid;
    }


    @Column(name = "clothingPrice")
    public String getClothingprice() {
        return clothingprice;
    }

    public void setClothingprice(String clothingprice) {
        this.clothingprice = clothingprice;
    }


    @Column(name = "clothingName")
    public String getClothingname() {
        return clothingname;
    }

    public void setClothingname(String clothingname) {
        this.clothingname = clothingname;
    }


    @Column(name = "clothingDescr")
    public String getClothingdescr() {
        return clothingdescr;
    }

    public void setClothingdescr(String clothingdescr) {
        this.clothingdescr = clothingdescr;
    }


    @Column(name = "orderFormID")
    public int getOrderformid() {
        return orderformid;
    }

    public void setOrderformid(int orderformid) {
        this.orderformid = orderformid;
    }


    @Column(name = "CIONum")
    public int getCionum() {
        return cionum;
    }

    public void setCionum(int cionum) {
        this.cionum = cionum;
    }

}
