package com.example.resturant.serviceImpl;

import com.example.resturant.entity.Dish;
import com.example.resturant.exception.UserException;
import com.example.resturant.repository.DishRepository;
import com.example.resturant.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishRepository dishRepository;



    @Override
    public Dish addDish(Dish dish) {

        String ex=null;

        try {
            if(dish ==null){
                throw new UserException("Please Enter Dish");
            }
            else {
                if(dish.getdName()==null){
                    ex="please enter name";
                    throw new UserException(ex);
                } else if (dish.getdPrice()==null) {
                    ex="please enter price";
                    throw new UserException(ex);
                } else if (dish.getdType()==null) {
                    ex="please entrt type";
                    throw new UserException(ex);
                }
            }
        } catch (Exception obj){
            System.out.println("Exception Occured"+obj.toString());
        }

        return dishRepository.save(dish);
    }

    @Override
    public Dish updateDish(Dish dish) {

        try{
            if(dish.getdId() ==null){
                throw new UserException("please enter dishId for update");
            }

        } catch (Exception e) {
            System.out.println("Exception occured :"+e.toString());
        }


        Optional<Dish> dishTemp=dishRepository.findById(dish.getdId());

        try{
            if(dishTemp.get()==null){
                throw new UserException("dish not found!!");
            }
        }catch (Exception e){
            System.out.println("Exception occured :"+e.toString());
        }


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
