package com.example.mfsp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "clothingrecomment")
public class Clothingrecomment {

    //null int(10)
    @Id
    private Integer clothingrecommentid;

    //null int(10)
    private Integer userid;

    //null int(10)
    private Integer clothingclassid;

    //null int(10)
    private Integer recommendweight;


    @Id
    @GeneratedValue()
    @Column(name = "clothingRecommentID")
    public Integer getClothingrecommentid() {
        return clothingrecommentid;
    }

    public void setClothingrecommentid(int clothingrecommentid) {
        this.clothingrecommentid = clothingrecommentid;
    }


    @Column(name = "userID")
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }


    @Column(name = "clothingClassID")
    public Integer getClothingclassid() {
        return clothingclassid;
    }

    public void setClothingclassid(Integer clothingclassid) {
        this.clothingclassid = clothingclassid;
    }


    @Column(name = "recommendWeight")
    public Integer getRecommendweight() {
        return recommendweight;
    }

    public void setRecommendweight(Integer recommendweight) {
        this.recommendweight = recommendweight;
    }

    @Override
    public String toString() {
        return "Clothingrecomment{" +
                "clothingrecommentid=" + clothingrecommentid +
                ", userid=" + userid +
                ", clothingclassid=" + clothingclassid +
                ", recommendweight=" + recommendweight +
                '}';
    }
}
