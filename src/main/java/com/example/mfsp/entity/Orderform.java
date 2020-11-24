package com.example.mfsp.entity;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;


@Entity
@Table(name = "orderform")
public class Orderform {

    //null int(10)
    @Id
    private Integer orderformid;

    //null int(10)
    private Integer orderformclass;

    //null int(10)
    private Integer userid;

    //null datetime(19)
    private Timestamp realityrentaltime;

    //null datetime(19)
    private Timestamp starttime;

    //null datetime(19)
    private Timestamp preconcertedreturntime;

    //null datetime(19)
    private Timestamp realityreturmtime;

    //null varchar(255)
    private String orderformaddress;

    //null varchar(50)
    private String totalprice;

    //null varchar(255)
    private String remark;

    //null varchar(50)
    private String orderstatus;


    @Id
    @GeneratedValue()
    @Column(name = "orderFormID")
    public Integer getOrderformid() {
        return orderformid;
    }

    public void setOrderformid(Integer orderformid) {
        this.orderformid = orderformid;
    }


    @Column(name = "orderFormClass")
    public Integer getOrderformclass() {
        return orderformclass;
    }

    public void setOrderformclass(Integer orderformclass) {
        this.orderformclass = orderformclass;
    }


    @Column(name = "userID")
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }


    @Column(name = "realityRentalTime")
    public Timestamp getRealityrentaltime() {
        return realityrentaltime;
    }

    public void setRealityrentaltime(Timestamp realityrentaltime) {
        this.realityrentaltime = realityrentaltime;
    }


    @Column(name = "startTime")
    public Timestamp getStarttime() {
        return starttime;
    }

    public void setStarttime(Timestamp starttime) {
        this.starttime = starttime;
    }


    @Column(name = "preconcertedReturnTime")
    public Timestamp getPreconcertedreturntime() {
        return preconcertedreturntime;
    }

    public void setPreconcertedreturntime(Timestamp preconcertedreturntime) {
        this.preconcertedreturntime = preconcertedreturntime;
    }


    @Column(name = "realityReturmTime")
    public Timestamp getRealityreturmtime() {
        return realityreturmtime;
    }

    public void setRealityreturmtime(Timestamp realityreturmtime) {
        this.realityreturmtime = realityreturmtime;
    }


    @Column(name = "orderFormAddress")
    public String getOrderformaddress() {
        return orderformaddress;
    }

    public void setOrderformaddress(String orderformaddress) {
        this.orderformaddress = orderformaddress;
    }


    @Column(name = "totalPrice")
    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }


    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    @Column(name = "orderStatus")
    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus;
    }

    @Override
    public String toString() {
        return "Orderform{" +
                "orderformid=" + orderformid +
                ", orderformclass=" + orderformclass +
                ", userid=" + userid +
                ", realityrentaltime=" + realityrentaltime +
                ", starttime=" + starttime +
                ", preconcertedreturntime=" + preconcertedreturntime +
                ", realityreturmtime=" + realityreturmtime +
                ", orderformaddress='" + orderformaddress + '\'' +
                ", totalprice='" + totalprice + '\'' +
                ", remark='" + remark + '\'' +
                ", orderstatus='" + orderstatus + '\'' +
                '}';
    }
}
