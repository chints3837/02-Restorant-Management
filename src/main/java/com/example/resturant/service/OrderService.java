package com.example.resturant.service;

import com.example.resturant.entity.Order;

public interface OrderService {

    Order addOrder(Order order,Integer tblId,Integer dishId);

    Order updateOrder(Integer oId,Integer tblId,Integer dishId);

    Integer getBillById(Integer id);
}
