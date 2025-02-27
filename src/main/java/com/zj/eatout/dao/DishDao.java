package com.zj.eatout.dao;

import com.zj.eatout.dto_DataTransferObject.DishRequest;
import com.zj.eatout.model.Dish;

public interface DishDao {

    Dish getDishById(Integer dishId);
    Integer createDish(DishRequest dishRequest);
    void deleteDish(Integer dishId);
    void updateDish(Integer dishId, DishRequest dishRequest);

}
