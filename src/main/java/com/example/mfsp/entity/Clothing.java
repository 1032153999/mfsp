package com.example.mfsp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "clothing")
public class Clothing {

    //null int(10)
    private int clothingid;

    //null varchar(255)
    private String clothingname;

    //null varchar(255)
    private String clothingdescr;

    //null varchar(50)
    private String clothingprice;

    //null varchar(50)
    private String clothingrentprice;

    //null int(10)
    private Integer clothingmonrentalamount;

    //null int(10)
    private Integer clothingmonthlysales;

    //null varchar(20)
    private String clothingstatus;

    //null int(10)
    private Integer clothingnum;

    //null varchar(255)
    private String clothingpic;

    //null varchar(50)
    private String clothingcost;


    @Id
    @GeneratedValue()
    @Column(name = "clothingID")
    public Integer getClothingid() {
        return clothingid;
    }

    public void setClothingid( int clothingid) {
        this.clothingid = clothingid;
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


    @Column(name = "clothingPrice")
    public String getClothingprice() {
        return clothingprice;
    }

    public void setClothingprice(String clothingprice) {
        this.clothingprice = clothingprice;
    }


    @Column(name = "clothingRentPrice")
    public String getClothingrentprice() {
        return clothingrentprice;
    }

    public void setClothingrentprice(String clothingrentprice) {
        this.clothingrentprice = clothingrentprice;
    }


    @Column(name = "clothingMonRentalAmount")
    public Integer getClothingmonrentalamount() {
        return clothingmonrentalamount;
    }

    public void setClothingmonrentalamount(Integer clothingmonrentalamount) {
        this.clothingmonrentalamount = clothingmonrentalamount;
    }


    @Column(name = "clothingMonthlySales")
    public Integer getClothingmonthlysales() {
        return clothingmonthlysales;
    }

    public void setClothingmonthlysales(Integer clothingmonthlysales) {
        this.clothingmonthlysales = clothingmonthlysales;
    }


    @Column(name = "clothingStatus")
    public String getClothingstatus() {
        return clothingstatus;
    }

    public void setClothingstatus(String clothingstatus) {
        this.clothingstatus = clothingstatus;
    }


    @Column(name = "clothingNum")
    public Integer getClothingnum() {
        return clothingnum;
    }

    public void setClothingnum(Integer clothingnum) {
        this.clothingnum = clothingnum;
    }


    @Column(name = "clothingPic")
    public String getClothingpic() {
        return clothingpic;
    }

    public void setClothingpic(String clothingpic) {
        this.clothingpic = clothingpic;
    }


    @Column(name = "clothingCost")
    public String getClothingcost() {
        return clothingcost;
    }

    public void setClothingcost(String clothingcost) {
        this.clothingcost = clothingcost;
    }

    @Override
    public String toString() {
        return "Clothing{" +
                "clothingid=" + clothingid +
                ", clothingname='" + clothingname + '\'' +
                ", clothingdescr='" + clothingdescr + '\'' +
                ", clothingprice='" + clothingprice + '\'' +
                ", clothingrentprice='" + clothingrentprice + '\'' +
                ", clothingmonrentalamount=" + clothingmonrentalamount +
                ", clothingmonthlysales=" + clothingmonthlysales +
                ", clothingstatus='" + clothingstatus + '\'' +
                ", clothingnum=" + clothingnum +
                ", clothingpic='" + clothingpic + '\'' +
                ", clothingcost='" + clothingcost + '\'' +
                '}';
    }
}
