package com.example.mfsp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "clothingsize")
public class Clothingsize {

    //null int(10)
    private int clothingsizeid;

    //null int(10)
    private int clothingid;

    //null varchar(20)
    private String sizename;


    @Id
    @GeneratedValue()
    @Column(name = "clothingSizeID")
    public int getClothingsizeid() {
        return clothingsizeid;
    }

    public void setClothingsizeid(int clothingsizeid) {
        this.clothingsizeid = clothingsizeid;
    }


    @Column(name = "clothingID")
    public int getClothingid() {
        return clothingid;
    }

    public void setClothingid(int clothingid) {
        this.clothingid = clothingid;
    }


    @Column(name = "sizeName")
    public String getSizename() {
        return sizename;
    }

    public void setSizename(String sizename) {
        this.sizename = sizename;
    }

}
