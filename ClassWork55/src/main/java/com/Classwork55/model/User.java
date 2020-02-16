package com.Classwork55.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;

@XmlRootElement(name = "user")
public class User {
    private Integer id;
    private String name;
    private String password;
    private Timestamp createdDate;

    public User(Integer id, String name, String password, Timestamp createdDate) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.createdDate = createdDate;
    }

    public User(String name, String password, Timestamp createdDate) {
        this.name = name;
        this.password = password;
        this.createdDate = createdDate;
    }

    public User(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }
}
