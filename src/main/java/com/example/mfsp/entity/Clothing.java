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
    private int clothingmonrentalamount;

    //null int(10)
    private int clothingmonthlysales;

    //null varchar(20)
    private String clothingstatus;

    //null int(10)
    private int clothingnum;

    //null varchar(255)
    private String clothingpic;

    //null varchar(50)
    private String clothingcost;


    @Id
    @GeneratedValue()
    @Column(name = "clothingID")
    public int getClothingid() {
        return clothingid;
    }

    public void setClothingid(int clothingid) {
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
    public int getClothingmonrentalamount() {
        return clothingmonrentalamount;
    }

    public void setClothingmonrentalamount(int clothingmonrentalamount) {
        this.clothingmonrentalamount = clothingmonrentalamount;
    }


    @Column(name = "clothingMonthlySales")
    public int getClothingmonthlysales() {
        return clothingmonthlysales;
    }

    public void setClothingmonthlysales(int clothingmonthlysales) {
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
    public int getClothingnum() {
        return clothingnum;
    }

    public void setClothingnum(int clothingnum) {
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

}
