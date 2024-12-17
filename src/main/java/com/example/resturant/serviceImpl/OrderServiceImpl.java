package com.example.resturant.serviceImpl;

import com.example.resturant.entity.Dish;
import com.example.resturant.entity.Order;
import com.example.resturant.entity.RestoTable;
import com.example.resturant.repository.DishRepository;
import com.example.resturant.repository.OrderRepository;
import com.example.resturant.repository.RestoTableRepository;
import com.example.resturant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestoTableRepository restoTableRepository;

    @Autowired
    private DishRepository dishRepository;

    @Override
    public Order addOrder(Order order,Integer tblId,Integer dishId) {

        //getTable data
        Optional<RestoTable> restoTableTemp = restoTableRepository.findById(tblId);
        restoTableTemp.get().setActive(true);

        Optional<Dish> dishTemp=dishRepository.findById(dishId);

        Order orderTemp=new Order();

//        List<Dish> orderDishList=orderTemp.getDishList();

        orderTemp.setTblorder(restoTableTemp.get());
        orderTemp.setoName(order.getoName());
        orderTemp.setDish(dishTemp.get());

        Order orderResult = orderRepository.save(orderTemp);

        return orderResult;

    }

    @Override
    public Order updateOrder(Integer oId, Integer tblId, Integer dishId) {

        Optional<Order> OrderTemp=orderRepository.findById(oId);

        Optional<Dish> dishTemp=dishRepository.findById(dishId);

        OrderTemp.get().setDish(dishTemp.get());

        Order orderResult = orderRepository.save(OrderTemp.get());

        return orderResult;
    }

    @Override
    public Integer getBillById(Integer id) {

        Integer totalBill=0;


        Integer orderId= orderRepository.findOrderIdByTableId(id);


        Optional<Order> order= orderRepository.findById(orderId);


        List<Dish> orderDishList= order.get().getDishList();

        for(Dish d:order.get().getDishList()){
            totalBill=totalBill+d.getdPrice();
        }
        System.out.println("Total Bill is :"+totalBill);


        return totalBill;

    }


}
