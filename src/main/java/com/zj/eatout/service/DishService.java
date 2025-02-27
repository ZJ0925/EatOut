package com.zj.eatout.service;

import com.zj.eatout.dto_DataTransferObject.DishRequest;
import com.zj.eatout.model.Dish;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.RequestBody;

public interface DishService {
    Dish getDishById(Integer dishId);
    Integer createDish(DishRequest dishRequest);
    void deleteDish(Integer dishId);
    void updateDish(Integer dishId, DishRequest dishRequest);
}
