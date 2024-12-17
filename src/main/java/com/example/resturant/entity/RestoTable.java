package com.example.resturant.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "restotbl")
public class RestoTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer tId;

    public String tName;

    public Boolean isActive;

    public RestoTable(){

    }

    public RestoTable(Integer tId, String tName, Boolean isActive) {
        this.tId = tId;
        this.tName = tName;
        this.isActive = isActive;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
