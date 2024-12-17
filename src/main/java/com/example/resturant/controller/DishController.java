package com.example.resturant.controller;

import com.example.resturant.entity.Dish;
import com.example.resturant.service.DishService;
import com.example.resturant.serviceImpl.DishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DishController {

    @Autowired
    private DishServiceImpl dishService;


    @PostMapping("/addDish")
    public Dish addDish(@RequestBody Dish dish){

        Dish dishResult=dishService.addDish(dish);
        return dishResult;
    }

    @PutMapping("/updateDish")
    public Dish updateDish(@RequestBody Dish dish){

        Dish dishResult= dishService.updateDish(dish);

        return dishResult;
    }

    @GetMapping("/getAllDish")
    public List<Dish> getAllDish(){
        List<Dish> dishList=dishService.getAllDish();
        return dishList;
    }
}
