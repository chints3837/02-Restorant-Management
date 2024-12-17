package com.example.resturant.serviceImpl;

import com.example.resturant.entity.Dish;
import com.example.resturant.repository.DishRepository;
import com.example.resturant.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishRepository dishRepository;



    @Override
    public Dish addDish(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public Dish updateDish(Dish dish) {

        Optional<Dish> dishTemp=dishRepository.findById(dish.getdId());

        dishTemp.get().setdName(dish.getdName());
        dishTemp.get().setdPrice(dish.getdPrice());
        dishTemp.get().setdType(dish.getdType());

        Dish dishResult= dishRepository.save(dishTemp.get());

        return dishResult;
    }

    @Override
    public List<Dish> getAllDish() {
        List<Dish> dishList= dishRepository.findAll();
        return dishList;
    }
}
