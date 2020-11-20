package com.example.mfsp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "clothingrecomment")
public class Clothingrecomment {

    //null int(10)
    private int clothingrecommentid;

    //null int(10)
    private int userid;

    //null int(10)
    private int clothingclassid;

    //null int(10)
    private int recommendweight;


    @Id
    @GeneratedValue()
    @Column(name = "clothingRecommentID")
    public int getClothingrecommentid() {
        return clothingrecommentid;
    }

    public void setClothingrecommentid(int clothingrecommentid) {
        this.clothingrecommentid = clothingrecommentid;
    }


    @Column(name = "userID")
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }


    @Column(name = "clothingClassID")
    public int getClothingclassid() {
        return clothingclassid;
    }

    public void setClothingclassid(int clothingclassid) {
        this.clothingclassid = clothingclassid;
    }


    @Column(name = "recommendWeight")
    public int getRecommendweight() {
        return recommendweight;
    }

    public void setRecommendweight(int recommendweight) {
        this.recommendweight = recommendweight;
    }

}
