package com.zj.eatout.service.impl;

import com.zj.eatout.dao.FoodDao;
import com.zj.eatout.dto_DataTransferObject.FoodRequest;
import com.zj.eatout.model.Food;
import com.zj.eatout.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodDao foodDao;

    @Override
    public Food getFoodById(Integer foodId) {
        return foodDao.getFoodById(foodId);
    }

    @Override
    public Integer createFood(FoodRequest foodRequest) {
        return foodDao.createFood(foodRequest);
    }

    @Override
    public void updateFood(Integer foodId, FoodRequest foodRequest) {
        foodDao.updateFood(foodId, foodRequest);
    }

    @Override
    public void deleteFood(Integer foodId) {
        foodDao.deleteFood(foodId);
    }
}
