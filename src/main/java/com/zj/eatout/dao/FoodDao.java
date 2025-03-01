package com.zj.eatout.dao;

import com.zj.eatout.dto_DataTransferObject.FoodRequest;
import com.zj.eatout.model.Food;

public interface FoodDao {
    Food getFoodById(Integer dishId);
    Integer createFood(FoodRequest foodRequest);
    void updateFood(Integer foodId, FoodRequest foodRequest);
    void deleteFood(Integer foodId);
}
