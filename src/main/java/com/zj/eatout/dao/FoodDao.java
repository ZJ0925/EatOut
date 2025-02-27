package com.zj.eatout.dao;

import com.zj.eatout.model.Food;

public interface FoodDao {
    Food getFood(Integer dishId);
}
