package com.example.resturant.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.aspectj.weaver.ast.Or;

@Entity
@Table(name = "dishtbl")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer dId;

    public String dName;

    public String dType;

    public Integer dPrice;

    public Dish(){

    }

    public Dish(Integer dId, String dType, Integer dPrice) {
        this.dId = dId;
        this.dType = dType;
        this.dPrice = dPrice;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getdType() {
        return dType;
    }

    public void setdType(String dType) {
        this.dType = dType;
    }

    public Integer getdPrice() {
        return dPrice;
    }

    public void setdPrice(Integer dPrice) {
        this.dPrice = dPrice;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }
}
