package com.example.resturant.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ordertbl")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer oId;

    public String oName;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tbl_Id")
    private RestoTable tblorder;

    @ManyToMany
    public List<Dish> dishList=new ArrayList<>();

    public Order(){

    }


    public Order(Integer oId, String oName, RestoTable tblorder, List<Dish> dishList) {
        this.oId = oId;
        this.oName = oName;
        this.tblorder = tblorder;
        this.dishList = dishList;
    }

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public String getoName() {
        return oName;
    }

    public void setoName(String oName) {
        this.oName = oName;
    }

    public RestoTable getTblorder() {
        return tblorder;
    }

    public void setTblorder(RestoTable tblorder) {
        this.tblorder = tblorder;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }
    public void setDish(Dish dish){
        this.dishList.add(dish);
    }

}
