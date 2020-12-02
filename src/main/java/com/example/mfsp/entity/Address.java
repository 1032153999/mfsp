package com.example.mfsp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "address")
public class Address {

    //null int(10)
    @Id
    private Integer id;

    //null varchar(255)
    private String useraddress;

    //null int(10)
    private Integer userid;

    private Integer userphone;

    private String username;


    @Id
    @GeneratedValue()
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name ="username")
    public String getUsername(){
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Column(name ="userphone")
    public Integer getUserphone(){ return userphone;}

    public void setUserphone(Integer userphone) {
        this.userphone = userphone;
    }

    @Column(name = "userAddress")
    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }


    @Column(name = "userID")
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", useraddress='" + useraddress + '\'' +
                ", userid=" + userid +
                '}';
    }
}
