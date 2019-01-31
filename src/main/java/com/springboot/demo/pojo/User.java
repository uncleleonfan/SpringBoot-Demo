package com.springboot.demo.pojo;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias(value = "user")
public class User implements Serializable {

    private int id;
    private String userName;
    private String note;
    private SexEnum sex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }
}
