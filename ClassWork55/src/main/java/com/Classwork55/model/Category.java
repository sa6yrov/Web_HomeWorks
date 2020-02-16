package com.Classwork55.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;

@XmlRootElement(name = "category")
public class Category {
    private Integer id;
    private String name;
    private Integer userId;
    private Integer ParentCategoryId;
    private boolean isActive;
    private Timestamp createdDate;

    public Category(Integer id, String name, Integer userId, Integer parentCategoryId, boolean isActive, Timestamp createdDate) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        ParentCategoryId = parentCategoryId;
        this.isActive = isActive;
        this.createdDate = createdDate;
    }

    public Category(String name, Integer userId, Integer parentCategoryId, boolean isActive, Timestamp createdDate) {
        this.name = name;
        this.userId = userId;
        ParentCategoryId = parentCategoryId;
        this.isActive = isActive;
        this.createdDate = createdDate;
    }
    public Category(){}

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getParentCategoryId() {
        return ParentCategoryId;
    }

    public void setParentCategoryId(Integer parentCategoryId) {
        ParentCategoryId = parentCategoryId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }
}

