package com.zj.eatout.service.impl;

import com.zj.eatout.dao.DishDao;
import com.zj.eatout.dto_DataTransferObject.DishRequest;
import com.zj.eatout.model.Dish;
import com.zj.eatout.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class DishServiceImpl implements DishService {
    @Autowired
    private DishDao dishDao;

    @Override
    public Dish getDishById(Integer dishId) {
        return  dishDao.getDishById(dishId);
    }

    @Override
    public Integer createDish(DishRequest dishRequest) {
        return dishDao.createDish(dishRequest);
    }

    @Override
    public void deleteDish(Integer dishId) {
        dishDao.deleteDish(dishId);
    }

    @Override
    public void updateDish(Integer dishId, DishRequest dishRequest) {
        dishDao.updateDish(dishId, dishRequest);
    }
}
