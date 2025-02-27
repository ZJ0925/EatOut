package com.zj.eatout.dao.impl;

import com.zj.eatout.dao.FoodDao;
import com.zj.eatout.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class FoodDaoImpl implements FoodDao {
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Food getFood(Integer dishId) {
        String sql = "";

        return null;
    }
}
