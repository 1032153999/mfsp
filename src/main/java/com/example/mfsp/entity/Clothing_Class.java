package com.example.mfsp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "clothing_class")
public class Clothing_Class {

    //null int(10)
    private int clothingClassid;

    //null int(10)
    private int clothingid;

    //null int(10)
    private int clothingclassid;


    @Id
    @GeneratedValue()
    @Column(name = "clothing_classID")
    public int getClothingClassid() {
        return clothingClassid;
    }

    public void setClothingClassid(int clothingClassid) {
        this.clothingClassid = clothingClassid;
    }


    @Column(name = "clothingID")
    public int getClothingid() {
        return clothingid;
    }

    public void setClothingid(int clothingid) {
        this.clothingid = clothingid;
    }


    @Column(name = "clothingClassID")
    public int getClothingclassid() {
        return clothingclassid;
    }

    public void setClothingclassid(int clothingclassid) {
        this.clothingclassid = clothingclassid;
    }

}
