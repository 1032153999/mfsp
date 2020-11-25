package com.example.mfsp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "clothinginorder")
public class Clothinginorder {

    //null int(10)
    @Id
    private Integer clothinginorderid;

    //null int(10)
    private Integer clothingid;

    //null varchar(50)
    private String clothingprice;

    //null varchar(255)
    private String clothingname;

    //null varchar(255)
    private String clothingdescr;

    //null int(10)
    private Integer orderformid;

    //null int(10)
    private Integer cionum;


    @Id
    @GeneratedValue()
    @Column(name = "clothingInOrderID")
    public Integer getClothinginorderid() {
        return clothinginorderid;
    }

    public void setClothinginorderid(Integer clothinginorderid) {
        this.clothinginorderid = clothinginorderid;
    }


    @Column(name = "clothingID")
    public Integer getClothingid() {
        return clothingid;
    }

    public void setClothingid(Integer clothingid) {
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
    public Integer getOrderformid() {
        return orderformid;
    }

    public void setOrderformid(Integer orderformid) {
        this.orderformid = orderformid;
    }


    @Column(name = "CIONum")
    public Integer getCionum() {
        return cionum;
    }

    public void setCionum(Integer cionum) {
        this.cionum = cionum;
    }

    @Override
    public String toString() {
        return "Clothinginorder{" +
                "clothinginorderid=" + clothinginorderid +
                ", clothingid=" + clothingid +
                ", clothingprice='" + clothingprice + '\'' +
                ", clothingname='" + clothingname + '\'' +
                ", clothingdescr='" + clothingdescr + '\'' +
                ", orderformid=" + orderformid +
                ", cionum=" + cionum +
                '}';
    }
}
