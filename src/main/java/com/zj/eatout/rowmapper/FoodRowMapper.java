package com.zj.eatout.rowmapper;

import com.zj.eatout.model.Food;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FoodRowMapper implements RowMapper<Food> {
    @Override
    public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
        Food food = new Food();
        food.setFoodId(rs.getInt("food_id"));
        food.setFoodName(rs.getString("food_name"));
        return food;
    }
}
