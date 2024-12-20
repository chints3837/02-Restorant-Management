package com.example.resturant.serviceImpl;

import com.example.resturant.entity.Dish;
import com.example.resturant.entity.Order;
import com.example.resturant.entity.RestoTable;
import com.example.resturant.exception.UserException;
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

        String ex=null;

        try{

            if(tblId==null){
                ex="please entrt tblid";
                throw new UserException(ex);
            } else if (dishId==null) {
                ex="please enter dishId";
                throw new UserException(ex);
            } else if (order.getoName()==null) {
                ex="please enter dishId";
                throw new UserException(ex);
            }
        }catch (Exception e){
            System.out.println("Exception Occured :"+e.toString());
        }


        //getTable data
        Optional<RestoTable> restoTableTemp = restoTableRepository.findById(tblId);

        try{
            if(restoTableTemp.get()==null){
                ex="Restorant not found";
            }
        }catch (Exception e){
            System.out.println("Exception occured :"+e.toString());
        }
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

        String ex;
        try{
            if(oId==null){
                ex="please enter order Id";
            } else if (tblId==null) {
                ex="please enter table no";
            } else if (dishId==null) {
                ex="please enter dish id";
            }
        }catch (Exception e){
            System.out.println("Exception Occred :"+e.toString());
        }



        Optional<Order> OrderTemp=orderRepository.findById(oId);
        Optional<Dish> dishTemp=dishRepository.findById(dishId);

        try{
            if(OrderTemp.get()==null){
                ex="Order Object Not Found";
                throw new UserException(ex);
            } else if (dishTemp.get()==null) {
                ex="Dish Object Not Found";
                throw new UserException(ex);
            }
        }catch (Exception e){
            System.out.println("Exception Occured :"+e.toString());
        }

        OrderTemp.get().setDish(dishTemp.get());

        Order orderResult = orderRepository.save(OrderTemp.get());

        return orderResult;
    }

    @Override
    public Integer getBillById(Integer id) {

        Integer totalBill=0;

        try{
            if(id==null){
                throw new UserException("Please enter valid bill-id");
            }
        }catch (Exception e){
            System.out.println("Exception occured :"+e.toString());
        }



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
