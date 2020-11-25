package com.example.mfsp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "clothingclass")
public class Clothingclass {

    //null int(10)
    @Id
    private Integer clothingclassid;

    //null varchar(255)
    private String clothingclassname;


    @Id
    @GeneratedValue()
    @Column(name = "clothingClassID")
    public Integer getClothingclassid() {
        return clothingclassid;
    }

    public void setClothingclassid(Integer clothingclassid) {
        this.clothingclassid = clothingclassid;
    }


    @Column(name = "clothingClassName")
    public String getClothingclassname() {
        return clothingclassname;
    }

    public void setClothingclassname(String clothingclassname) {
        this.clothingclassname = clothingclassname;
    }

    @Override
    public String toString() {
        return "Clothingclass{" +
                "clothingclassid=" + clothingclassid +
                ", clothingclassname='" + clothingclassname + '\'' +
                '}';
    }
}
