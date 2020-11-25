package com.example.mfsp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "clothingsize")
public class Clothingsize {

    //null int(10)
    @Id
    private Integer clothingsizeid;

    //null int(10)
    private Integer clothingid;

    //null varchar(20)
    private String sizename;


    @Id
    @GeneratedValue()
    @Column(name = "clothingSizeID")
    public Integer getClothingsizeid() {
        return clothingsizeid;
    }

    public void setClothingsizeid(Integer clothingsizeid) {
        this.clothingsizeid = clothingsizeid;
    }


    @Column(name = "clothingID")
    public Integer getClothingid() {
        return clothingid;
    }

    public void setClothingid(Integer clothingid) {
        this.clothingid = clothingid;
    }


    @Column(name = "sizeName")
    public String getSizename() {
        return sizename;
    }

    public void setSizename(String sizename) {
        this.sizename = sizename;
    }

    @Override
    public String toString() {
        return "Clothingsize{" +
                "clothingsizeid=" + clothingsizeid +
                ", clothingid=" + clothingid +
                ", sizename='" + sizename + '\'' +
                '}';
    }
}
