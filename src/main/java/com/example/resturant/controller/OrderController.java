package com.example.resturant.controller;


import com.example.resturant.entity.Order;
import com.example.resturant.serviceImpl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @PostMapping("/saveOrder")
    public Order saveOrder(@RequestBody Order order,
                           @RequestParam("tId") Integer tId,@RequestParam("dId") Integer dishId){

        Order orderResult=orderService.addOrder(order,tId,dishId);
        return orderResult;
    }

    @PutMapping("/updateOrder")
    public Order updateOrder(@RequestParam("oId") Integer oId,
                             @RequestParam("tId") Integer tId,@RequestParam("dId") Integer dishId){
        Order orderResult=orderService.updateOrder(oId,tId,dishId);
        return orderResult;
    }

    @GetMapping("/getBillByTableId")
    public Integer getBillByTableId(@RequestParam("tId") Integer tId){
        Integer iBill= this.orderService.getBillById(tId);
        return iBill;
    }
}
