package com.example.mfsp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "class")
public class clothingclass {


    @Id
    private Integer clothingclassid;

    private String FirstKind;

    private String SecondKind;

    private String ThirdlyKind;

    public Integer getClassid() {
        return clothingclassid;
    }

    public void setClassid(Integer classid) {
        this.clothingclassid = clothingclassid;
    }

    public String getFirstKind() {
        return FirstKind;
    }

    public void setFirstKind(String firstKind) {
        FirstKind = firstKind;
    }

    public String getSecondKind() {
        return SecondKind;
    }

    public void setSecondKind(String secondKind) {
        SecondKind = secondKind;
    }

    public String getThirdlyKind() {
        return ThirdlyKind;
    }

    public void setThirdlyKind(String thirdlyKind) {
        ThirdlyKind = thirdlyKind;
    }

    @Override
    public String toString() {
        return "clothingclass{" +
                "classid=" + clothingclassid +
                ", FirstKind=" + FirstKind +
                ", SecondKind='" + SecondKind + '\'' +
                ", ThirdlyKind=" + ThirdlyKind +
                '}';
    }
}

