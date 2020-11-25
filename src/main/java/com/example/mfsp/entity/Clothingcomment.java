package com.example.mfsp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "clothingcomment")
public class Clothingcomment {

    //null int(10)
    @Id
    private Integer clothingcommentid;

    //null int(10)
    private Integer userid;

    //null varchar(255)
    private String comment;

    //null int(10)
    private Integer clothingid;


    @Id
    @GeneratedValue()
    @Column(name = "clothingCommentID")
    public Integer getClothingcommentid() {
        return clothingcommentid;
    }

    public void setClothingcommentid(Integer clothingcommentid) {
        this.clothingcommentid = clothingcommentid;
    }


    @Column(name = "userID")
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }


    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    @Column(name = "clothingID")
    public Integer getClothingid() {
        return clothingid;
    }

    public void setClothingid(Integer clothingid) {
        this.clothingid = clothingid;
    }

    @Override
    public String toString() {
        return "Clothingcomment{" +
                "clothingcommentid=" + clothingcommentid +
                ", userid=" + userid +
                ", comment='" + comment + '\'' +
                ", clothingid=" + clothingid +
                '}';
    }
}
