package com.zj.eatout.service;

import com.zj.eatout.dto_DataTransferObject.FoodRequest;
import com.zj.eatout.model.Food;

public interface FoodService {
    Food getFoodById(Integer foodId);
    Integer createFood(FoodRequest foodRequest);
    void updateFood(Integer foodId, FoodRequest foodRequest);
    void deleteFood(Integer foodId);

}
