package com.example.mfsp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "clothingcomment")
public class Clothingcomment {

    //null int(10)
    private int clothingcommentid;

    //null int(10)
    private int userid;

    //null varchar(255)
    private String comment;

    //null int(10)
    private int clothingid;


    @Id
    @GeneratedValue()
    @Column(name = "clothingCommentID")
    public int getClothingcommentid() {
        return clothingcommentid;
    }

    public void setClothingcommentid(int clothingcommentid) {
        this.clothingcommentid = clothingcommentid;
    }


    @Column(name = "userID")
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
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
    public int getClothingid() {
        return clothingid;
    }

    public void setClothingid(int clothingid) {
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
