package com.example.resturant.service;

import com.example.resturant.entity.Dish;

import java.util.List;

public interface DishService {

    Dish addDish(Dish dish);

    Dish updateDish(Dish dish);

    List<Dish> getAllDish();
}
