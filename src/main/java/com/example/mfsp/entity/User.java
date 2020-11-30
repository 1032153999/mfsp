package com.example.mfsp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "user")
public class User {

    //null int(10)
    @Id
    private Integer userid;

    //null varchar(50)
    private String username;

    //null varchar(50)
    private String userpassword;

    //null varchar(20)
    private String userrole;

    //null varchar(50)
    private String userpic;

    //null int(10)
    private Integer phone;

    private String userstatus;


    @Id
    @GeneratedValue()
    @Column(name = "userID")
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }


    @Column(name="userstatus")
    public String getUserstatus(){ return  userstatus; }

    public void setUserstatus(String userstatus){ this.userstatus=userstatus;
    }

    @Column(name = "userName")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Column(name = "userPassword")
    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }


    @Column(name = "userRole")
    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }


    @Column(name = "userPic")
    public String getUserpic() {
        return userpic;
    }

    public void setUserpic(String userpic) {
        this.userpic = userpic;
    }


    @Column(name = "phone")
    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", userrole='" + userrole + '\'' +
                ", userpic='" + userpic + '\'' +
                ", phone=" + phone +
                '}';
    }
}
